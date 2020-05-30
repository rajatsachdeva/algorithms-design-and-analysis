package com.rohan.dsa.foundations.graph.node;

import java.util.*;

/**
 * A sophisticated implementation using Adjacency List
 */
public class Graph<T> {
    private List<Edge<T>> edges;
    private Map<Integer, Vertex<T>> vertices;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        this.edges = new ArrayList<>();
        this.vertices = new HashMap<>();
    }

    public Graph() {
        this(false);
    }

    public void addEdge(int sourceId, int destinationId) {
        addEdge(sourceId, destinationId, 0);
    }

    public void addEdge(int sourceId, int destinationId, int weight) {
        Vertex<T> sourceVertex = getVertex(sourceId);
        Vertex<T> destinationVertex = getVertex(destinationId);
        Edge<T> edge = new Edge<>(sourceVertex, destinationVertex, weight, directed);
        edges.add(edge);
        sourceVertex.addAdjacentVertex(edge, destinationVertex);
        if (!directed) {
            destinationVertex.addAdjacentVertex(edge, sourceVertex);
        }
    }

    private Vertex<T> getVertex(int id) {
        if (vertices.containsKey(id)) {
            return vertices.get(id);
        } else {
            Vertex<T> vertex = new Vertex<>(id);
            vertices.put(id, vertex);
            return vertex;
        }
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values();
    }

    public void setDataForVertex(long id, T data) {
        if (vertices.containsKey(id)) {
            Vertex<T> vertex = vertices.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Edge<T> edge : getEdges()) {
            builder.append(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
            builder.append("\n");
        }
        return builder.toString();
    }

    public static class Vertex<T> {
        private int id;
        private T data;
        private List<Edge<T>> edges;
        private List<Vertex<T>> adjacentVertices;

        public Vertex(int id, T data) {
            this.id = id;
            this.data = data;
            this.edges = new ArrayList<>();
            this.adjacentVertices = new ArrayList<>();
        }

        public Vertex(int id) {
            this(id, null);
        }

        public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex) {
            this.edges.add(edge);
            this.adjacentVertices.add(vertex);
        }

        public void setData(T data) {
            this.data = data;
        }

        public int degree() {
            return edges.size();
        }

        public int getId() {
            return id;
        }

        public T getData() {
            return data;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        public List<Vertex<T>> getAdjacentVertices() {
            return adjacentVertices;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return id == vertex.id &&
                    Objects.equals(data, vertex.data) &&
                    Objects.equals(edges, vertex.edges) &&
                    Objects.equals(adjacentVertices, vertex.adjacentVertices);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, data, edges, adjacentVertices);
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    public static class Edge<T> {

        private Vertex<T> source;
        private Vertex<T> destination;
        private int weight;
        private boolean isDirected;

        public Edge(Vertex<T> source, Vertex<T> destination, int weight, boolean isDirected) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        public Edge(Vertex<T> source, Vertex<T> destination) {
            this(source, destination, 0, false);
        }

        public Edge(Vertex<T> source, Vertex<T> destination, boolean isDirected) {
            this.source = source;
            this.destination = destination;
            this.isDirected = isDirected;
        }

        public Vertex<T> getSource() {
            return source;
        }

        public void setSource(Vertex<T> source) {
            this.source = source;
        }

        public Vertex<T> getDestination() {
            return destination;
        }

        public void setDestination(Vertex<T> destination) {
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean isDirected() {
            return isDirected;
        }

        public void setDirected(boolean directed) {
            isDirected = directed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?> edge = (Edge<?>) o;
            return weight == edge.weight &&
                    isDirected == edge.isDirected &&
                    Objects.equals(source, edge.source) &&
                    Objects.equals(destination, edge.destination);
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, weight, isDirected);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex1=" + source +
                    ", vertex2=" + destination +
                    ", weight=" + weight +
                    ", isDirected=" + isDirected +
                    '}';
        }
    }
}
