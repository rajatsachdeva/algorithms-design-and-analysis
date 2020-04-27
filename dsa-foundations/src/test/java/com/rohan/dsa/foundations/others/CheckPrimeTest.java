package com.rohan.dsa.foundations.others;

import org.junit.Test;

import static com.rohan.dsa.foundations.others.CheckPrime.isPrimeUsingForLoop;
import static com.rohan.dsa.foundations.others.CheckPrime.isPrimeUsingWhileLoop;
import static org.junit.Assert.*;

public class CheckPrimeTest {
    @Test
    public void testCheckPrimeUsingForLoop() {
        assertTrue(isPrimeUsingForLoop(1));
        assertTrue(isPrimeUsingForLoop(2));
        assertTrue(isPrimeUsingForLoop(3));
        assertFalse(isPrimeUsingForLoop(4));
        assertFalse(isPrimeUsingForLoop(15));
        assertTrue(isPrimeUsingForLoop(17));
        assertFalse(isPrimeUsingForLoop(20));
    }

    @Test
    public void testCheckPrimeUsingWhileLoop() {
        assertTrue(isPrimeUsingWhileLoop(1));
        assertTrue(isPrimeUsingWhileLoop(2));
        assertTrue(isPrimeUsingWhileLoop(3));
        assertFalse(isPrimeUsingWhileLoop(4));
        assertFalse(isPrimeUsingWhileLoop(15));
        assertTrue(isPrimeUsingWhileLoop(17));
        assertFalse(isPrimeUsingWhileLoop(20));
    }

}