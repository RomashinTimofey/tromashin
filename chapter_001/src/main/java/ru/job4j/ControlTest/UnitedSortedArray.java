package ru.job4j.ControlTest;

/**     * Class for Unite 2 sorted array
        * @author Timofey Romashin
        * @version $Id$
        * @since 0.1
 */

public class UnitedSortedArray {
    /**
     *
     * @param firstArray is first
     * @param secondArray is second
     * @return unitedArray
     */
    public int[] sortedArrays(int[] firstArray, int[] secondArray) {
        int[] unitedArray = new int[firstArray.length + secondArray.length];
        int first = 0;
        int second = 0;

        for(int united = 0; united<unitedArray.length; united++) {
            if (firstArray[first] < secondArray[second] && first < firstArray.length) {
                unitedArray[united] = firstArray[first];
                first++;
            } else {
                unitedArray[united] = secondArray[second];
                second++;
            }
            // Проверка на выход за предел массива, если они не равны по кол-ву элементов.
            if (first >= firstArray.length) {
                for (; second<secondArray.length; second++) {
                    united++;
                    unitedArray[united] = secondArray[second];
                }
            }
            if (second >= secondArray.length) {
                for (; first<firstArray.length; first++) {
                    united++;
                    unitedArray[united] = firstArray[first];
                }
            }
        }
        return unitedArray;
    }
}
