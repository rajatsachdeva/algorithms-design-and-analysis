package com.rohan.dsa.foundations.graph;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * Given a directed acyclic graph, do a topological sort on this graph.
 *
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 *
 * Space and time complexity is O(n).
 */
public class TopologicalSort<T> {

    public Stack<Vertex<T>> topologicalSort(Graph<T> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Vertex<T>> stack = new Stack<>();

        for (Vertex<T> vertex : graph.getVertices()) {
            if (!visited.contains(vertex.getId())) {
                topologicalSortHelper(vertex, stack, visited);
            }
        }
        return stack;
    }

    private void topologicalSortHelper(Vertex<T> vertex,
                                       Stack<Vertex<T>> stack,
                                       Set<Integer> visited) {
        visited.add(vertex.getId());
        for (Vertex<T> neighbor : vertex.getAdjacentVertices()) {
            if (!visited.contains(neighbor.getId())) {
                topologicalSortHelper(neighbor, stack, visited);
            }
        }
        stack.push(vertex);
    }


    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(true);

        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>();
        final Stack<Vertex<Integer>> resultStack = topologicalSort.topologicalSort(graph);
        System.out.println("Sorted result:-");
        while (!resultStack.isEmpty()) {
            System.out.print(resultStack.pop() + " ");
        }
    }
}
