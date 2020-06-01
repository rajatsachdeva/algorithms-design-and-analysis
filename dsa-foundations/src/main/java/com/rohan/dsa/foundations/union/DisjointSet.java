package com.rohan.dsa.foundations.union;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 * <p>
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 * total time will be O(m). Proof in Coreman book.
 */
public class DisjointSet<T> {

    private Map<T, Node> nodeMap = new HashMap<>();

    private class Node {
        private int rank;
        private T data;
        private Node parent;
    }

    public void makeSet(T data) {
        Node node = new Node();
        node.rank = 0;
        node.data = data;
        node.parent = node;
        nodeMap.put(data, node);
    }

    public boolean union(T data1, T data2) {
        Node node1 = nodeMap.get(data1);
        Node node2 = nodeMap.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        // They are in the same set.
        if (parent1 == parent2) {
            return false;
        }

        if (parent1.rank >= parent2.rank) {

            // if rank is same, then increment any side.
            // Here we are choosing parent1
            if (parent1.rank == parent2.rank) {
                parent1.rank += 1;
            }
            // Here parent1 rank is greater than parent2.
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    public T findSet(T data) {
        return findSet(nodeMap.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     *
     * By compression we will find the node fast
     *
     * @param node
     * @return
     */
    public Node findSet(Node node) {
        Node parent = node.parent;
        if (node == parent) {
            return parent;
        }
        // Path compression
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public static void main(String[] args) {

        DisjointSet<Integer> ds = new DisjointSet<>();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }
}
