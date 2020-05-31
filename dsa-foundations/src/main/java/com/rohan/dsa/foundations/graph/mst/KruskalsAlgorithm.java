package com.rohan.dsa.foundations.graph.mst;

import com.rohan.dsa.foundations.graph.node.Graph;
import com.rohan.dsa.foundations.graph.node.Graph.Edge;
import com.rohan.dsa.foundations.graph.node.Graph.Vertex;
import com.rohan.dsa.foundations.union.DisjointSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Minimum Spanning Tree
 */
public class KruskalsAlgorithm {

    public List<Edge<Integer>> getMST(Graph<Integer> graph) {

        // Get list of edges & vertices
        List<Edge<Integer>> edges = graph.getEdges();
        Collection<Vertex<Integer>> vertices = graph.getVertices();

        // Sort the edges in increasing order
        edges.sort(new EdgeComparator());

        // Create a disjoint sets as many as vertex in the graph
        DisjointSet<Integer> disjointSet = new DisjointSet<>();
        for (Vertex<Integer> vertex : vertices) {
            disjointSet.makeSet(vertex.getId());
        }

        List<Edge<Integer>> result = new ArrayList<>();

        for (Edge<Integer> edge : edges) {

            final int sourceVertexId = edge.getSource().getId();
            final int destinationVertexId = edge.getDestination().getId();
            // Get the set of two vertices of the edge.
            // rootX represent the parent
            int root1 = disjointSet.findSet(sourceVertexId);
            int root2 = disjointSet.findSet(destinationVertexId);

            // Check if the vertices are in same set or different set
            if (root1 == root2) {
                // Vertices are in the same
                continue;
            } else {
                // Vertices are in different set.
                // Now add the edge to the result and union the two sets into one
                result.add(edge);
                disjointSet.union(sourceVertexId, destinationVertexId);
            }

        }
        return result;
    }

    private static class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            return edge1.getWeight() - edge2.getWeight();
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);

        KruskalsAlgorithm mst = new KruskalsAlgorithm();
        List<Edge<Integer>> result = mst.getMST(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getSource() + " " + edge.getDestination());
        }
    }
}
