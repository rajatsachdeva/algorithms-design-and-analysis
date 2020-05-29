package com.rohan.dsa.foundations.graph.traversal;


import com.rohan.dsa.foundations.graph.node.GraphNode;

import java.util.LinkedList;
import java.util.Queue;

public class BFSUsingAdjMatrix {
    private GraphNode[] vertices;
    private boolean[][] adjMatrix;
    private int numVertices;

    public BFSUsingAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
        vertices = new GraphNode[numVertices];

        for (int i = 0; i < numVertices; i++) {
            vertices[i] = new GraphNode("V" + i);
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            display(current);
            markVisited(current);
            int neighbor = getUnvisitedNeighbor(current);
            while (neighbor != -1) {
                markVisited(neighbor);
                queue.add(neighbor);
                neighbor = getUnvisitedNeighbor(current);
            }
        }
        resetVerticesState();
    }

    private void display(int vertexIndex) {
        System.out.println(vertices[vertexIndex]);
    }

    private void markVisited(int vertexIndex){
        vertices[vertexIndex].setVisited(true);
    }
    private int getUnvisitedNeighbor(int v) {
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[v][i] && !vertices[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    private void resetVerticesState() {
        for (int i = 0; i < numVertices; i++) {
            vertices[i].setVisited(false);
        }
    }

    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = true;
        adjMatrix[destination][source] = true;
    }

    public static void main(String[] args) {
        BFSUsingAdjMatrix graph = new BFSUsingAdjMatrix(5);

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
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.bfs();
    }
}
