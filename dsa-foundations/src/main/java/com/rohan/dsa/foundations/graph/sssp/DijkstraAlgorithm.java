package com.rohan.dsa.foundations.graph.sssp;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Edge;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Source Shortest Path

 * Time Complexity
 * Space complexity - O(E + V)
 * Time complexity - O(ElogV)
 *
 * References:-
 *
 * https://www.youtube.com/watch?v=smHnz2RHJBY (Hinglish) - Concept
 * https://www.youtube.com/watch?v=FSm1zybd0Tk (Impl)
 * https://www.youtube.com/watch?v=lAXZGERcDf4&t=17s (Impl)
 * https://www.youtube.com/watch?v=2E7MmKv0Y24&index=16&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb (MIT)
 */
public class DijkstraAlgorithm {

    public Map<Vertex<Integer>, Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {

        // Priority queue, so that we can select a minimum cost vertex each time
        MinPriorityQueue<Vertex<Integer>> minPriorityQueue = new MinPriorityQueue<>();

        // Distance Map; Stores shortest distance from root(source) to every vertex
        Map<Vertex<Integer>, Integer> distance = new HashMap<>();

        // Parent Map; Stores parent of every vertex in the shortest distance
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

        // Initialize all the vertex with infinite distance value from the source vertex
        for (Vertex<Integer> vertex : graph.getVertices()) {
            minPriorityQueue.add(Integer.MAX_VALUE, vertex);
        }

        // Set distance of source vertex to 0
        minPriorityQueue.update(sourceVertex, 0);

        // Update the distance map for sourceVertex
        distance.put(sourceVertex, 0);

        // Source vertex parent will be null
        parent.put(sourceVertex, null);

        // Iterate till PQ is empty
        while (!minPriorityQueue.isEmpty()) {
            // Get the min value from heap node which has vertex and distance of that vertex from source vertex.
            MinPriorityQueue<Vertex<Integer>>.Node node = minPriorityQueue.extractMinNode();
            Vertex<Integer> current = node.key;

            // Update shortest distance of current vertex from the source vertex
            distance.put(current, node.weight);

            // Iterate through all the edges of current vertex
            for (Edge<Integer> edge : current.getEdges()) {

                // Get the adjacent vertex
                Vertex<Integer> adjacent = edge.getAdjacentVertex(current);

                // If heap does not contain vertex means adjacent vertex already has shortest distance from source vertex
                if (!minPriorityQueue.containsData(adjacent)) {
                    // Means the node is already visited and distance is already decided
                    continue;
                }

                // Add distance of current vertex to edge weight to get distance of adjacent vertex from the source vertex
                // when it goes through current vertex
                int newDistance = distance.get(current) + edge.getWeight();

                // Check if this above calculated distance is less than current distance stored for adjacent vertex from
                // source vertex.
                int adjacentWeight = minPriorityQueue.getWeight(adjacent);
                if (adjacentWeight > newDistance) {
                    minPriorityQueue.update(adjacent, newDistance);
                    parent.put(adjacent, current);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        Vertex<Integer> sourceVertex = graph.getVertexAt(1);
        final Map<Vertex<Integer>, Integer> distance = algorithm.shortestPath(graph, sourceVertex);

        /*
          Expected : {1=0, 2=5, 3=7, 4=7, 5=3, 6=5}
         */
        System.out.println(distance);

        Graph<Integer> directedGraph = new Graph<>(true);

        directedGraph.addEdge(10, 20, 10);
        directedGraph.addEdge(10, 30, 5);
        directedGraph.addEdge(20, 40, 1);
        directedGraph.addEdge(30, 20, 3);
        directedGraph.addEdge(30, 40, 9);
        directedGraph.addEdge(30, 50, 2);
        directedGraph.addEdge(50, 10, 2);

        sourceVertex = directedGraph.getVertexAt(10);
        final Map<Vertex<Integer>, Integer> directedDistance = algorithm.shortestPath(directedGraph, sourceVertex);

        /*
          Expected : {10=0, 20=8, 30=5, 40=9, 50=7}
         */
        System.out.println(directedDistance);
    }
}
