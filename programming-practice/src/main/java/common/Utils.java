package common;

import java.util.Iterator;
import java.util.List;

public class Utils {

    public static int[] convertIntegers(List<Integer> list) {
        int[] rets = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            rets[index++] = iterator.next();
        }
        return rets;
    }
}
