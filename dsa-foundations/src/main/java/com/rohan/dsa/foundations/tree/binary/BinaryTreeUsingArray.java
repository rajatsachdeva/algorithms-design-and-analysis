package com.rohan.dsa.foundations.tree.binary;

import java.util.NoSuchElementException;

public class BinaryTreeUsingArray {

    private int[] tree;
    private int lastUsedIndex;

    // Creation
    public BinaryTreeUsingArray(int size) {
        this.tree = new int[size];
        lastUsedIndex = 0;
    }

    public void insert(int item) {
        if (isFull()) {
            throw new IllegalStateException("Is Full");
        }
        lastUsedIndex++;
        tree[lastUsedIndex] = item;
    }

    public int search(int item) {
        for (int i = 1; i < lastUsedIndex; i++) {
            if (tree[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int item) {
        int deleteIndex = search(item);
        if (deleteIndex == -1) {
            throw new NoSuchElementException();
        }

        tree[deleteIndex] = tree[lastUsedIndex];
        lastUsedIndex--;
    }

    public boolean isFull() {
        return lastUsedIndex == tree.length - 1;
    }

    public boolean isEmpty() {
        return lastUsedIndex == 0;
    }

    // Traversal
    public void levelOrder() {
        for (int i = 0; i < lastUsedIndex; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println("");
    }

    //VLR
    public void preOrder(int index) {
        if(index > lastUsedIndex){
            return;
        }

        preOrder(2 * index);
        System.out.print(tree[index] + " ");
        preOrder(2 * index + 1);
    }

    //LVR
    public void inOrder(int index) {
        if(index > lastUsedIndex){
            return;
        }

        preOrder(2 * index);
        System.out.print(tree[index] + " ");
        preOrder(2 * index + 1);
    }

    public void postOrder(int index) {
        if(index > lastUsedIndex){
            return;
        }

        preOrder(2 * index);
        preOrder(2 * index + 1);
        System.out.print(tree[index] + " ");
    }
}
