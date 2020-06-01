package com.rohan.dsa.foundations.graph;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Detect cycle in directed graph
 * <p>
 * WhiteSet: Not yet explored
 * GraySet: Exploring (If the a vertex is found to be added on second time then we have a cycle)
 * BlackSet: Completely explored
 * <p>
 * Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
 * Space Complexity :O(V).
 * Since an extra color array is needed of size V.
 * <p>
 * References:-
 * <p>
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
public class CycleInDirectedGraph {

    public boolean hasCycle(Graph<Integer> graph) {
        Set<Vertex<Integer>> whiteSet = new HashSet<>();
        Set<Vertex<Integer>> graySet = new HashSet<>();
        Set<Vertex<Integer>> blackSet = new HashSet<>();

        final Collection<Vertex<Integer>> vertices = graph.getVertices();

        // Put all the vertices in the un
        whiteSet.addAll(vertices);

        while (whiteSet.size() > 0) {
            // Pick any random vertex
            Vertex<Integer> current = whiteSet.iterator().next();
            if (dfsVisit(current, whiteSet, graySet, blackSet)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfsVisit(Vertex<Integer> current,
                             Set<Vertex<Integer>> whiteSet,
                             Set<Vertex<Integer>> graySet,
                             Set<Vertex<Integer>> blackSet) {
        // Move from from white to gray set when starting to explore
        moveVertex(current, whiteSet, graySet);

        // Explore the neighbors
        for (Vertex<Integer> neighbor : current.getAdjacentVertices()) {

            if (blackSet.contains(neighbor)) {
                // Already explored or visited
                continue;
            }

            if (graySet.contains(neighbor)) {
                // Cycle detected
                return true;
            }

            // Apply dfs visit on neighbor.
            if (dfsVisit(neighbor, whiteSet, graySet, blackSet)) {
                return true;
            }
        }

        // Move vertex from gray to black set when done exploring
        moveVertex(current, graySet, blackSet);
        return false;
    }

    private void moveVertex(Vertex<Integer> current,
                            Set<Vertex<Integer>> sourceSet, Set<Vertex<Integer>> destinationSet) {
        sourceSet.remove(current);
        destinationSet.add(current);
    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        CycleInDirectedGraph detector = new CycleInDirectedGraph();
        System.out.println(detector.hasCycle(graph));
    }
}
