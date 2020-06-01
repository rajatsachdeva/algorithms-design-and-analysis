package com.rohan.dsa.foundations.graph;


import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Edge;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;
import com.rohan.dsa.foundations.union.DisjointSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an undirected graph find cycle in this graph.
 * <p>
 * Solution
 * This can be solved in many ways.
 * Below is the code to solve it using disjoint sets and DFS.
 * <p>
 * Runtime and space complexity for both the techniques is O(v)
 * where v is total number of vertices in the graph.
 */
public class CycleInUndirectedPath {

    public boolean hasCycleUsingDisjointSets(Graph<Integer> graph) {
        DisjointSet<Integer> disjointSet = new DisjointSet<>();

        // Create disjoint sets
        for (Vertex<Integer> vertex : graph.getVertices()) {
            disjointSet.makeSet(vertex.getId());
        }

        // For all edges, check if in same parent
        for (Edge<Integer> edge : graph.getEdges()) {
            final int sourceId = edge.getSource().getId();
            final int destinationId = edge.getDestination().getId();

            int parent1 = disjointSet.findSet(sourceId);
            int parent2 = disjointSet.findSet(destinationId);

            if (parent1 == parent2) {
                return true;
            }
            disjointSet.union(sourceId, destinationId);
        }

        return false;
    }


    public boolean hasCycleUsingDFS(Graph<Integer> graph) {
        Set<Vertex<Integer>> visited = new HashSet<>();
        for (Vertex<Integer> vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                if (dfsCycleHelper(vertex, null, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycleHelper(Vertex<Integer> current,
                                   Vertex<Integer> parent,
                                   Set<Vertex<Integer>> visited) {
        visited.add(current);
        for (Vertex<Integer> neighbor : current.getAdjacentVertices()) {

            // This covers the scenario when we are the in a recursive call, and the parent
            // is discovered again as a neighbor of the current node.
            if (neighbor.equals(parent)) {
                continue;
            }

            if (visited.contains(neighbor)) {
                return true;
            }

            if (dfsCycleHelper(neighbor, parent, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CycleInUndirectedPath cycle = new CycleInUndirectedPath();
        Graph<Integer> graph = new Graph<Integer>();

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        boolean isCycle = cycle.hasCycleUsingDisjointSets(graph);
        System.out.println(isCycle);
        isCycle = cycle.hasCycleUsingDFS(graph);
        System.out.println(isCycle);
    }

}
