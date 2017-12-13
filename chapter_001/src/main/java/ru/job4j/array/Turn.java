package ru.job4j.array;

/**
 * Class for find index of element
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    /**
     *
     * @param array for work with revers
     * @return reverse array
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int saverValue = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = i;
        }
        return array;
    }

}
