package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.BinaryNode;
import com.rohan.dsa.foundations.tree.Queue;

public class LevelOrderTraversal {

    public void levelOrder(BinaryNode root) {
        Queue<BinaryNode> queue = new Queue<>();
        queue.enqueue(root);
        BinaryNode first = null;
        while (!queue.isEmpty()) {
            first = queue.dequeue();
            BinaryNode leftChild = first.getLeft();
            BinaryNode rightChild = first.getRight();
            if (leftChild != null) {
                queue.enqueue(leftChild);
            }
            if (rightChild != null) {
                queue.enqueue(rightChild);
            }
            System.out.print(first);
        }
        System.out.println("");
    }
}
