package com.rohan.dsa.foundations.graph.sssp;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Edge;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Source Shortest Path
 */
public class BellmanFordAlgorithm {

    private static final int INFINITY = 10000000;

    public Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {

        Map<Vertex<Integer>, Integer> distance = new HashMap<>();
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

        // Set distance of every vertex to be infinity
        // Also, initialize parent of each vertex to null, initially
        for (Vertex<Integer> vertex : graph.getVertices()) {
            distance.put(vertex, INFINITY);
            parent.put(vertex, null);
        }

        // Set distance of the source of vertex to 0
        distance.put(sourceVertex, 0);

        // Get number of vertices
        int numVertices = graph.getVertices().size();

        // Relax the edges from numVertices - 1 times
        for (int i = 0; i < numVertices - 1; i++) {
            for (Edge<Integer> edge : graph.getEdges()) {

                Vertex<Integer> u = edge.getSource();
                Vertex<Integer> v = edge.getDestination();

                // Relax the edge, if we get better distance to v via u, then we will
                // use this distance and also set u as a parent of v
                int distanceToU = distance.get(u) + edge.getWeight();
                int distanceAtV = distance.get(v);
                if (distanceToU < distanceAtV) {
                    distance.put(v, distanceToU);
                    parent.put(v, u);
                }
            }
        }

        // Relax all edges again. If we still get lesser distance it means
        // there is negative weight cycle in the graph. Throw exception in that case
        for (Edge<Integer> edge : graph.getEdges()) {
            Vertex<Integer> u = edge.getSource();
            Vertex<Integer> v = edge.getDestination();
            int distanceToU = distance.get(u) + edge.getWeight();
            int distanceAtV = distance.get(v);
            if (distanceToU < distanceAtV) {
                throw new RuntimeException("Detected Negative Weight Cycle");
            }
        }

        return distance;
    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 3, 8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 3, 1);

        BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm();
        Vertex<Integer> startVertex = graph.getVertices().iterator().next();
        Map<Vertex<Integer>, Integer> distance = algorithm.shortestPath(graph, startVertex);
        System.out.println(distance);
    }
}
