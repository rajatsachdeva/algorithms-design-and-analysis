package com.rohan.dsa.foundations.graph.traversal;

import com.rohan.dsa.foundations.graph.node.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Lame Implementation and naive
 */
public class BFSUsingAdjList {
    private List<GraphNode> nodeList;

    public BFSUsingAdjList(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited()) {
                visit(node);
            }
        }
    }

    private void visit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            current.setVisited(true);
            System.out.println(current);
            for (GraphNode neighbor : current.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }

    public void addEdge(int source, int destination) {
        GraphNode sourceNode = nodeList.get(source);
        GraphNode destinationNode = nodeList.get(destination);
        sourceNode.getNeighbors().add(destinationNode);
        destinationNode.getNeighbors().add(sourceNode);
    }

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            nodeList.add(new GraphNode("V" + i));
        }

        BFSUsingAdjList graph = new BFSUsingAdjList(nodeList);

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
