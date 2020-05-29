package com.rohan.dsa.foundations.graph.traversal;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

    public static void bfs(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<>();

        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (!visited.contains(vertex.getId())) {
                queue.add(vertex);
                visited.add(vertex.getId());
                while (!queue.isEmpty()) {
                    Vertex<Integer> visitedVertex = queue.poll();
                    System.out.println(visitedVertex);
                    for (Vertex<Integer> adjacentVertex : visitedVertex.getAdjacentVertices()) {
                        if (!visited.contains(adjacentVertex.getId())) {
                            queue.add(adjacentVertex);
                            visited.add(adjacentVertex.getId());
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(5, 3);

        bfs(graph);
    }

}
