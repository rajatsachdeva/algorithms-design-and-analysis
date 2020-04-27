package com.rohan.dsa.foundations.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResizableArrayTest {

    private ResizableArray resizableArray;

    @Before
    public void setup() {
        resizableArray = new ResizableArray(2);
    }

    @Test
    public void testSetVal() {
        resizableArray.setVal(0, 10);
        resizableArray.setVal(1, 20);

        Assert.assertArrayEquals(resizableArray.getArr(), new int[]{10, 20});
    }

    @Test
    public void testGetVal() {
        resizableArray.setVal(0, 10);
        resizableArray.setVal(1, 20);
        Assert.assertEquals(resizableArray.getVal(1), 20);
    }

    @Test
    public void test_pushBack() {
        resizableArray.pushBack(10);
        resizableArray.pushBack(20);

        Assert.assertArrayEquals(resizableArray.getArr(), new int[]{10, 20});
        Assert.assertEquals(2, resizableArray.length());

        resizableArray.pushBack(30);
        resizableArray.pushBack(40);
        resizableArray.pushBack(50);
        resizableArray.pushBack(60);

        Assert.assertArrayEquals(new int[]{10, 20, 30, 40, 50, 60, 0, 0}, resizableArray.getArr());
        Assert.assertEquals(8, resizableArray.length());
    }

    @Test
    public void test_pop() {
        resizableArray.pushBack(10);
        resizableArray.pushBack(20);
        resizableArray.pushBack(30);
        resizableArray.pushBack(40);
        resizableArray.pushBack(50);
        resizableArray.pushBack(60);

        Assert.assertEquals(8, resizableArray.length());

        resizableArray.pop();
        resizableArray.pop();
        resizableArray.pop();
        int val = resizableArray.pop();
        Assert.assertEquals(30, val);
        Assert.assertEquals(4, resizableArray.length());
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_onSetVal_throwsExceptionWhenInvalid_whenInvalidIndexPassed() {
        resizableArray.setVal(-1, 10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_onGetVal_throwsExceptionWhenInvalid_whenInvalidIndexPassed() {
        resizableArray.getVal(-2);
    }
}