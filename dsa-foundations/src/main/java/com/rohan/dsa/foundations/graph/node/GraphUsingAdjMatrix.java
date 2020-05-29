package com.rohan.dsa.foundations.graph.node;

public class GraphUsingAdjMatrix {

    private boolean[][] adjMatrix;
    private int numVertices;

    public GraphUsingAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        requiresValidVertex(source);
        requiresValidVertex(destination);

        adjMatrix[source][destination] = true;
        adjMatrix[destination][source] = true;
    }

    public void removeEdge(int source, int destination) {
        requiresValidVertex(source);
        requiresValidVertex(destination);

        adjMatrix[source][destination] = false;
        adjMatrix[destination][source] = false;
    }

    public boolean isEdge(int source, int destination) {
        return isValidVertex(source) && isValidVertex(destination) && adjMatrix[source][destination];
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
