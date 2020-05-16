package com.rohan.dsa.foundations.tree.binary;

import com.rohan.dsa.foundations.tree.Queue;
import com.rohan.dsa.foundations.tree.TreeNode;

/**
 * Given a binary tree print each level on new line.
 * <p>
 * e.g           10
 * 5         15
 * 0   -1    2    6
 * Output :   10
 * 5 15
 * 0 -1 2 6
 * <p>
 * Solution
 * Technique 1:
 * Use 2 queue. Keep polling from q1 and offer to q2 till q1 is empty.
 * After that print a new line. Keep polling from q2 and offer to q1
 * till q2 is empty. Keep doing this still both q1 and q2 are empty.
 * <p>
 * Technique 2
 * Use one queue with delimiter. Add a delimiter null after every level.
 * As soon as you encounter a null print a new line and add null at end of queue
 * <p>
 * Technique 3
 * Use one queue with count. Keep count of nodes at every level. As soon as this
 * count is 0 print a new line.
 * <p>
 * Time space complexity for all above algorithm is O(n).
 */
public class TreeTraversalLevelByLevel {

    // Technique 1
    public void traverseByLevelUsingTwoQueues(TreeNode root) {

        Queue<TreeNode> q1 = new Queue<>();
        Queue<TreeNode> q2 = new Queue<>();
        q1.enqueue(root);

        TreeNode current = null;
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                current = q1.dequeue();
                System.out.print(current);
                if (current.left != null) {
                    q2.enqueue(current.left);
                }
                if (current.right != null) {
                    q2.enqueue(current.right);
                }
            }

            System.out.println();

            while (!q2.isEmpty()) {
                current = q2.dequeue();
                System.out.print(current);
                if (current.left != null) {
                    q1.enqueue(current.left);
                }
                if (current.right != null) {
                    q1.enqueue(current.right);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Technique 2
    public void traverseByLevelUsingDelimiter(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        queue.enqueue(null);

        TreeNode current = null;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            if (current != null) {
                System.out.print(current);
                if (current.left != null) {
                    queue.enqueue(current.left);
                }
                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.enqueue(null);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeTraversalLevelByLevel traversal = new TreeTraversalLevelByLevel();
        traversal.traverseByLevelUsingTwoQueues(root);
        traversal.traverseByLevelUsingDelimiter(root);


    }

}
