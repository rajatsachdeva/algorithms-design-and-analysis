package com.rohan.dsa.foundations.graph.traversal;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {

    public static void dfs(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<>();
        for (Vertex<Integer> vertex : graph.getVertices()) {
            if (!visited.contains(vertex.getId())) {
                dfsRecursive(vertex, visited);
            }
        }
    }

    private static void dfsRecursive(Vertex<Integer> vertex, Set<Integer> visited) {
        visited.add(vertex.getId());
        System.out.println(vertex);
        for (Vertex<Integer> neighbour : vertex.getAdjacentVertices()) {
            if (!visited.contains(neighbour.getId())) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    public static void dfsIterative(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Vertex<Integer>> stack = new Stack<>();

        for (Vertex<Integer> vertex : graph.getVertices()) {
            stack.push(vertex);
            while (!stack.isEmpty()) {
                Vertex<Integer> current = stack.pop();

                if (!visited.contains(current.getId())) {
                    visited.add(current.getId());
                    System.out.println(current);
                }

                for (Vertex<Integer> neighbor : current.getAdjacentVertices()) {
                    if (!visited.contains(neighbor.getId())) {
                        stack.push(neighbor);
                    }
                }
            } // End Of While
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        /*
         * 0-------1\
         * |       |  \ 2
         * |       |  /
         * 4-------3/
         *
         * */
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("DFS Recursive:-");
        dfs(graph);

        System.out.println("DFS Iterative:-");
        dfsIterative(graph);

        /*
         * Backtrack example
         *
         * A
         * |
         * |
         * B ------- H
         * |         |
         * |         |
         * C ------- E ------- G
         * |         |
         * |         |
         * D         F
         * */

    }

}
