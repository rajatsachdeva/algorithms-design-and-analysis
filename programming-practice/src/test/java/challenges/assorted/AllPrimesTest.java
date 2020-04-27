package challenges.assorted;

import org.junit.Test;

import static challenges.assorted.AllPrimes.getPrimeNumbersFast;
import static challenges.assorted.AllPrimes.getPrimeNumbersSlow;
import static org.junit.Assert.*;

public class AllPrimesTest {

    @Test
    public void testGetPrimesFast() {
        assertArrayEquals(getPrimeNumbersFast(20), new int[]{0, 1, 2, 3, 5, 7, 11, 13, 17, 19});
    }


    @Test
    public void testGetPrimesSlow() {
        assertArrayEquals(getPrimeNumbersSlow(20), new int[]{0, 1, 2, 3, 5, 7, 11, 13, 17, 19});
    }
}