package com.rohan.dsa.foundations.graph.sssp;

import com.rohan.dsa.foundations.graph.MinBinaryHeap;
import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Edge;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Source Shortest Path
 * <p>
 * <p>
 * <p>
 * Time Complexity
 * TODO
 * Space complexity - O(E + V)
 * Time complexity - O(ElogV)
 * <p>
 * References:-
 * <p>
 * https://www.youtube.com/watch?v=smHnz2RHJBY (Hinglish) - Concept
 * https://www.youtube.com/watch?v=FSm1zybd0Tk (Impl)
 * https://www.youtube.com/watch?v=lAXZGERcDf4&t=17s (Impl)
 * https://www.youtube.com/watch?v=2E7MmKv0Y24&index=16&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb (MIT)
 * https://www.techiedelight.com/single-source-shortest-paths-dijkstras-algorithm
 */
public class DijkstraAlgorithm {

    public void shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex) {

        // Priority queue, so that we can select a minimum cost vertex each time
        MinBinaryHeap<Vertex<Integer>> minPriorityQueue = new MinBinaryHeap<>();

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
            MinBinaryHeap<Vertex<Integer>>.Node node = minPriorityQueue.extractMinNode();
            Vertex<Integer> current = node.key;

            // Update shortest distance of current vertex from the source vertex
            distance.put(current, node.weight);

            // Iterate through all the edges of current vertex
            for (Edge<Integer> edge : current.getEdges()) {

                //TODO:

            }


        }
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

    }
}
