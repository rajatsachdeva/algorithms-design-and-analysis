package com.rohan.dsa.foundations.graph.node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphUsingAdjList {
    private List<List<Integer>> adjList;
    private int numVertices;

    public GraphUsingAdjList(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {

        requiresValidVertex(source);
        requiresValidVertex(destination);

        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    // A utility function to print the adjacency list
    // representation of graph
    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    private void requiresValidVertex(int vertex) {
        if (isValidVertex(vertex)) {
            throw new IllegalArgumentException("Invalid argument");
        }
    }

    private boolean isValidVertex(int vertex) {
        return vertex < 0 && vertex > numVertices - 1;
    }
}
