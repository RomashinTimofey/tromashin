package ru.job4j.array;

import java.util.Arrays;

/**
 * Class for delete duplicate in array
 *
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    /**
     * @param array for clean duplicate
     * @return cleaned array
     */
    public String[] remove(String[] array) {
        int copy = 0;
        for (int outside = 0; outside < array.length; outside++) {
            for (int inside = outside + 1; inside < array.length - copy; inside++) {
                if (array[outside].equals(array[inside])) {
                    array[inside] = array[array.length - copy - 1];
                    inside--; // for repeat check after replace
                    copy++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - copy);
    }
}
