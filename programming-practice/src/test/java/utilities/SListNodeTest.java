package utilities;

import org.junit.Test;


public class SListNodeTest {

    @Test
    public void testHelper() {
        SListNode<Integer> node = SListNodeHelper.createFromIntArray(new int[]{1, 2, 3, 4});
        SListNodeHelper.traverse(node);
    }

}