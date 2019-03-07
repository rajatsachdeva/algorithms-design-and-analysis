package utilities;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public enum ConversionHelper {

    INSTANCE;

    public int[] fromStringToIntArray(String str) {
        return Arrays.stream(str.split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
    }

    public int[] fromIntegerListToIntegerArray(List<Integer> integerList) {
        Integer[] integers = fromListToArray(Integer.class, integerList);
        return toPrimitive(integers);
    }

    private <T> T[] fromListToArray(Class<T> clazz, List<T> list) {
        @SuppressWarnings("unchecked")
        T[] rets = (T[]) Array.newInstance(clazz, list.size());
        Iterator<T> iterator = list.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            rets[index++] = iterator.next();
        }
        return rets;
    }

    int[] toPrimitive(Integer[] IntegerArray) {

        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }


}
