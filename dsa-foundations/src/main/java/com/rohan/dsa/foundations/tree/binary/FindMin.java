package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

public class FindMin {

    public int min(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int currMin = root.data;
        int leftMin = min(root.left);
        int rightMin = min(root.right);

        if (leftMin < currMin) {
            currMin = leftMin;
        }

        if (rightMin < currMin) {
            currMin = rightMin;
        }

        return currMin;
    }


    public int minIterative(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        int min = Integer.MAX_VALUE;
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            if (current.data < min) {
                min = current.data;
            }
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue((current.right));
            }
        }
        return min;
    }
}
