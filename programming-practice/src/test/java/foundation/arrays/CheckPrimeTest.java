package foundation.arrays;

import org.junit.Test;

import static foundation.arrays.CheckPrime.isPrimeUsingForLoop;
import static foundation.arrays.CheckPrime.isPrimeUsingWhileLoop;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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