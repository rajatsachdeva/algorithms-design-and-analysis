package utilities;

public class SListNodeHelper {

    public static SListNode<Integer> createFromIntArray(int[] array) {

        SListNode<Integer> sListNode = null;
        for (int value : array) {
            sListNode = insertRear(sListNode, value);
        }
        return sListNode;
    }

    public static SListNode<Integer> createFromIntArrayReverse(int[] array) {
        // Way 1: Loop the array in reverse and call insertRead

        // Way 2
        return insertFront(array, array.length);
    }

    public static void traverse(SListNode<Integer> node) {
        if (null != node) {
            System.out.print(node.data() + " -> ");
            traverse(node.next());
        } else {
            System.out.print("NULL");
        }
    }

    public static SListNode<Integer> insertFront(int[] array, int length) {
        if (length == 0) {
            return new SListNode<>(array[0]);
        }
        return new SListNode<>(array[length - 1], insertFront(array, length - 1));
    }

    public static SListNode<Integer> insertRear(SListNode<Integer> node, int value) {
        if (node == null)
            return new SListNode<>(value, null);
        else {
            node.setNext(insertRear(node.next(), value));
            return node;
        }
    }
}
