package com.rohan.dsa.foundations.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.empty());

        list.pushFront(1);
        list.pushFront(2);

        assertEquals("[2,1]", list.toString());

        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);

        assertEquals("[2,1,3,4,5,6]", list.toString());

        int front = list.front();
        assertEquals(2, front);

        int back = list.back();
        assertEquals(6, back);

        assertEquals(6, list.size());
        assertFalse(list.empty());

        int poppedFront = list.popFront();
        int poppedBack = list.popBack();

        assertEquals(2, poppedFront);
        assertEquals(6, poppedBack);

        assertEquals(4, list.size());
        assertFalse(list.empty());
        assertEquals("[1,3,4,5]", list.toString());

        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.empty());

        list.pushBack(1);
        list.pushBack(3);
        list.pushBack(5);
        list.pushBack(7);
        list.pushBack(8);
        assertEquals("[1,3,5,7,8]", list.toString());

        list.insert(1, 2);
        assertEquals("[1,2,3,5,7,8]", list.toString());

        list.insert(3, 4);
        assertEquals("[1,2,3,4,5,7,8]", list.toString());

        list.insert(5, 6);
        assertEquals("[1,2,3,4,5,6,7,8]", list.toString());

        list.insert(8, 9);
        assertEquals("[1,2,3,4,5,6,7,8,9]", list.toString());
        assertEquals(9, list.size());

        list.erase(4);
        assertEquals("[1,2,3,4,6,7,8,9]", list.toString());

        list.erase(0);
        assertEquals("[2,3,4,6,7,8,9]", list.toString());

        list.erase(6);
        assertEquals("[2,3,4,6,7,8]", list.toString());
        assertEquals(6, list.size());

        list.removeValue(2);
        list.removeValue(4);
        list.removeValue(8);
        list.removeValue(99);

        assertEquals("[3,6,7]", list.toString());
        assertEquals(3, list.size());

        list.clear();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.reverse();

        assertEquals("[5,4,3,2,1]", list.toString());

        assertEquals(2, (int) list.nthValueFromEnd(2));
    }
}