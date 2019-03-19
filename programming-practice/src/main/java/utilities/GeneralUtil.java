package utilities;

import java.util.Collection;
import java.util.Iterator;

public class GeneralUtil {

    public static <T> String print(Collection<T> collection) {
        StringBuilder sb = new StringBuilder();

        for (Iterator<T> collectorIterator = collection.iterator(); collectorIterator.hasNext(); ) {
            sb.append(collectorIterator.next());

            if (collectorIterator.hasNext())
                sb.append(",");
        }

        return sb.toString();
    }

    public static <T> String print(Collection<T> collection, String seperator) {
        StringBuilder sb = new StringBuilder();

        for (Iterator<T> collectorIterator = collection.iterator(); collectorIterator.hasNext(); ) {
            sb.append(collectorIterator.next());

            if (collectorIterator.hasNext())
                sb.append(seperator);
        }

        return sb.toString();
    }

    public static void createLinkedListFrom() {

    }
}
