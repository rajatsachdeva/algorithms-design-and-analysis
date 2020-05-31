package com.rohan.dsa.foundations.graph.mst;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Edge;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;
import com.rohan.dsa.foundations.graph.sssp.MinPriorityQueue;

import java.util.*;

/**
 * Find minimum spanning tree using Prim's algorithm
 * <p>
 * Space complexity - O(E + V)
 * Time complexity - O(ElogV)
 * <p>
 * References
 * https://en.wikipedia.org/wiki/Prim%27s_algorithm
 * CLRS book
 */
public class PrimsAlgorithm {

    private Collection<Edge<Integer>> getMST(Graph<Integer> graph) {

        MinPriorityQueue<Vertex<Integer>> minPriorityQueue = new MinPriorityQueue<>();

        // Map of vertex to edge, which gave minimum weight to this vertex, while extracting min
        Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();

        List<Edge<Integer>> result = new ArrayList<>();

        // Insert all the vertices with infinite value (greedy)
        for (Vertex<Integer> vertex : graph.getVertices()) {
            minPriorityQueue.add(Integer.MAX_VALUE, vertex);
        }

        // Start from any random vertex
        Vertex<Integer> startVertex = graph.getVertices().iterator().next();

        // For the start vertex update the value in PQ to 0
        minPriorityQueue.update(startVertex, 0);


        while (!minPriorityQueue.isEmpty()) {

            // Extract the minimum value vertex from PQ
            Vertex<Integer> current = minPriorityQueue.extractMin();

            // Get the corresponding edge for this vertex if present and add it to the final result
            // This edge won't be present for the first vertex
            Edge<Integer> spanningTreeEdge = vertexToEdge.get(current);
            if (spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }

            // Iterate through all the adjacent edges of current vertex
            for (Edge<Integer> edge : current.getEdges()) {

                // Get the adjacent vertex of this edge
                Vertex<Integer> adjacent = edge.getAdjacentVertex(current);

                // Check if adjacent vertex exist in the min PQ and weight of the
                // adjacent vertex is greater than edge weight
                if (minPriorityQueue.containsData(adjacent) &&
                        minPriorityQueue.getWeight(adjacent) > edge.getWeight()) {
                    // Update the value of the adjacent vertex in the min PQ.
                    minPriorityQueue.update(adjacent, edge.getWeight());

                    // Add this vertex and to the spanning helper tree map
                    vertexToEdge.put(adjacent, edge);
                }
            }
        } // End Of While

        return result;
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(false);

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimsAlgorithm prims = new PrimsAlgorithm();
        Collection<Edge<Integer>> edges = prims.getMST(graph);
        for (Edge<Integer> edge : edges) {
            System.out.println(edge);
        }
    }
}
