package com.rohan.dsa.foundations.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Data structure to support following operations
 * extractMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 *
 * It is a combination of binary heap and hash map
 *
 */
public class MinBinaryHeap<T> {

    private List<Node> allNodes = new ArrayList<>();
    private Map<T, Integer> nodePosition = new HashMap<>();
    private int size;

    public class Node {
        public int weight;
        public T key;

        public Node() {
        }

        public Node(int weight, T key) {
            this.weight = weight;
            this.key = key;
        }

        @Override
        public String toString() {
            return weight + " " + key;
        }
    }

    public void add(int weight, T key) {
        Node node = new Node(weight, key);
        allNodes.add(node);

        int size = allNodes.size();
        int currentIndex = size - 1;
        nodePosition.put(node.key, currentIndex);

        while (currentIndex > 0) {
            int parentIndex = parent(currentIndex);
            Node parentNode = allNodes.get(parentIndex);
            Node currentNode = allNodes.get(currentIndex);

            if (parentNode.weight > currentNode.weight) {
                swap(parentNode, currentNode);
                updateNodePosition(parentNode.key, currentNode.key, parentIndex, currentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Updating the weight of a given key to newWeight
     * <p>
     * Decreases the weight of given key to newWeight
     */
    public void update(T key, int newWeight) {
        Integer currentIndex = nodePosition.get(key);
        allNodes.get(currentIndex).weight = newWeight;

        while (currentIndex > 0) {
            int parentIndex = parent(currentIndex);
            Node currentNode = allNodes.get(currentIndex);
            Node parentNode = allNodes.get(parentIndex);
            if (parentNode.weight > currentNode.weight) {
                swap(parentNode, currentNode);
                updateNodePosition(parentNode.key, currentNode.key,
                        parentIndex, currentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * Returns the min node of the heap
     */
    public Node extractMinNode() {

        // Create Min Node
        Node minNode = new Node();
        minNode.key = allNodes.get(0).key;
        minNode.weight = allNodes.get(0).weight;

        // Get last node data
        int lastIndex = allNodes.size() - 1;
        int lastNodeWeight = allNodes.get(lastIndex).weight;
        T lastNodeKey = allNodes.get(lastIndex).key;

        // Replace with the first node
        allNodes.get(0).weight = lastNodeWeight;
        allNodes.get(0).key = lastNodeKey;

        // Remove from allNodes and nodePosition
        nodePosition.remove(minNode.key);

        nodePosition.remove(allNodes.get(0).key); // Removing old position
        nodePosition.put(allNodes.get(0).key, 0); // Adding new position
        allNodes.remove(lastIndex);

        minHeapify(0);
        return minNode;
    }

    private void minHeapify(int index) {

        int smallest = index;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (leftIndex < allNodes.size() &&
                allNodes.get(leftIndex).weight < allNodes.get(smallest).weight) {
            smallest = leftIndex;
        }

        if (rightIndex < allNodes.size() &&
                allNodes.get(rightIndex).weight < allNodes.get(smallest).weight) {
            smallest = rightIndex;
        }

        // Changed
        if (index != smallest) {
            Node indexNode = allNodes.get(index);
            Node smallestNode = allNodes.get(smallest);
            swap(indexNode, smallestNode);
            updateNodePosition(indexNode.key, smallestNode.key,
                    index, smallest);
            minHeapify(smallest);
        }
    }


    /**
     * Get the heap min without extracting the key
     */
    public T min() {
        return allNodes.get(0).key;
    }

    /**
     * Checks with heap is empty or not
     */
    public boolean isEmpty() {
        return allNodes.isEmpty();
    }

    /**
     * Get the weight of given key
     */
    public Integer getWeight(int key) {
        Integer position = nodePosition.get(key);
        if (position == null) {
            return null;
        } else {
            return allNodes.get(position).weight;
        }
    }

    private void printHeap() {
        for (Node node : allNodes) {
            System.out.println(node);
        }
    }

    private void printPositionMap() {
        System.out.println(nodePosition);
    }

    private int parent(int index) {
        if (index == 0) {
            return 0;
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(Node node1, Node node2) {
        int tempWeight = node1.weight;
        T tempKey = node1.key;

        node1.weight = node2.weight;
        node1.key = node2.key;

        node2.weight = tempWeight;
        node2.key = tempKey;
    }

    private void updateNodePosition(T parentKey, T currentKey, int parentIndex, int currentIndex) {
        nodePosition.remove(parentKey);
        nodePosition.remove(currentKey);

        nodePosition.put(parentKey, parentIndex);
        nodePosition.put(currentKey, currentIndex);
    }

    public static void main(String args[]) {
        MinBinaryHeap<String> heap = new MinBinaryHeap();
        heap.add(3, "Gon");
        heap.add(4, "Ichigo");
        heap.add(7, "Naruto");
        heap.add(10, "Goku");
        heap.add(5, "Deku");
        heap.add(6, "Chad");
        heap.add(2, "Aizen");
        heap.update("Goku", 1);
        heap.printHeap();
        heap.printPositionMap();

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMinNode());
        }

    }
}

