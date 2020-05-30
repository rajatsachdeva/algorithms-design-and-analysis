package com.rohan.dsa.foundations.graph.sssp;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Single Source Shortest Path
 * - Idea is find minimum path that covers all the nodes.
 * <p>
 * BFS Approach
 * - Only valid for unweighted graphs.
 */
public class FindPathUsingBFS {

    public void bfs(Vertex<Integer> vertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        queue.add(vertex);
        visited.add(vertex.getId());
        while (!queue.isEmpty()) {
            Vertex<Integer> current = queue.poll();
            printPath(current);
            for (Vertex<Integer> neighbor : current.getAdjacentVertices()) {
                if (!visited.contains(neighbor.getId())) {
                    neighbor.setParent(current);
                    queue.add(neighbor);
                    visited.add(neighbor.getId());
                }
            }
        }
    }

    private void printPath(Vertex<Integer> vertex) {
        System.out.print("Printing path for node " + vertex + ": ");
        printPathHelper(vertex);
        System.out.println();
    }

    private void printPathHelper(Vertex<Integer> vertex) {
        if (vertex.getParent() != null) {
            printPathHelper(vertex.getParent());
        }
        System.out.print(vertex.getId() + " ");
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.addEdge(0, 8);
        graph.addEdge(8, 2);
        graph.addEdge(8, 9);
        graph.addEdge(2, 1);
        graph.addEdge(9, 1);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 7);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(7, 6);
        graph.addEdge(5, 6);

        System.out.println("Printing BFS from source: 2");
        FindPathUsingBFS findPath = new FindPathUsingBFS();
        findPath.bfs(graph.getVertexAt(2));
    }
}

/*
    Expected Output:

    Printing BFS from source: 2
    Printing path for node 2: 2
    Printing path for node 8: 2 8
    Printing path for node 1: 2 1
    Printing path for node 4: 2 4
    Printing path for node 0: 2 8 0
    Printing path for node 9: 2 8 9
    Printing path for node 3: 2 1 3
    Printing path for node 7: 2 1 7
    Printing path for node 5: 2 1 3 5
    Printing path for node 6: 2 1 7 6
 */