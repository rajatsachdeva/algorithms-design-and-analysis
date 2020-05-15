package com.rohan.dsa.review.api;

/**
 * Template used for reviewing Binary Tree
 */
public interface BinaryTree {

    void insert(int item);

    void remove(int item);

    void delete();

    void max();

    void maxIterative();

    void size();

    void sizeIterative();

    void height();

    void heightIterative();

    boolean isSame(BinaryTree tree);

    boolean isBlank();

    boolean isMirror();

    int deepest();

    int leavesCount();

    int halfNodesCount();

    int fullNodesCount();

    int sum();

    int lowestCommonAncestorOf(int data);

    BinaryTree fromInOrderAndPostOrder(int[] inOrder, int[] postOrder);

    BinaryTree fromInOrderAndPreOrder(int[] inOrder, int[] preOrder);

    BinaryTree fromPostOrderAndInOrder(int[] preOrder, int[] postOrder);

    BinaryTree mirror();

    String preOrder();

    String preOrderIterative();

    String inOrder();

    String inOrderIterative();

    String postOrder();

    String postOrderIterative();

    String levelOrder();

    String reverseLevelOrder();

    void printByLevel();

    void printSpiral();
}
