package com.rohan.dsa.foundations.graph.apsp;

/**
 * Floyd-Warshall Algorithm for finding all pair shortest path.
 * <p>
 * Time complexity - O(V^3)
 * Space complexity - O(V^2)
 * <p>
 * References
 * https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
 */
public class FloydWarshallAlgorithm {

    private static final int INF = 1000000;

    public int[][] allPairShortestPath(int[][] distanceMatrix) {

        int[][] distance = new int[distanceMatrix.length][distanceMatrix.length];
        int[][] path = new int[distanceMatrix.length][distanceMatrix.length];

        // Create a base distance and path matrix
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix.length; j++) {
                distance[i][j] = distanceMatrix[i][j];
                if (distanceMatrix[i][j] != INF && i != j) {
                    path[i][j] = i; // Initially via its own vertex
                } else {
                    path[i][j] = -1; // No path
                }
            }
        }

        for (int k = 0; k < distanceMatrix.length; k++) {
            for (int i = 0; i < distanceMatrix.length; i++) {
                for (int j = 0; j < distanceMatrix.length; j++) {

                    // No need of trying to calculate further as INF will always be greater
                    if (distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }

                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j]; // K is the "via" node
                    }
                }
            }
        }

        //look for negative weight cycle in the graph
        //if values on diagonal of distance matrix is negative
        //then there is negative weight cycle in the graph.
        for (int i = 0; i < distance.length; i++) {
            if (distance[i][i] < 0) {
                throw new RuntimeException("Found negative weight cycle");
            }
        }

        return distance;
    }


    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 6, 15},
                {INF, 0, -2, INF},
                {INF, INF, 0, 2},
                {1, INF, INF, 0}
        };

        FloydWarshallAlgorithm shortestPath = new FloydWarshallAlgorithm();

        int[][] distance = shortestPath.allPairShortestPath(graph);
        System.out.println("Minimum Distance matrix");
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
