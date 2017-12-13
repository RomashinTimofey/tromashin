package ru.job4j.array;

/**
 * Class for sort Array as bubbleSort
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     *
     * @param array for sort
     * @return sorted array as bubble Method
     */
    public int[] sort(int[] array) {
        for(int i=0; i<array.length; i++) {
            for (int j=0; j<array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
