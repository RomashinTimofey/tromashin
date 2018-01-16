package ru.job4j.array;


/**
 * Class for find index of element
 *
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Method find el in array
     *
     * @param data array
     * @param el   find this el in data array
     * @return index of element
     */
    public int indexOf(int[] data, int el) {
        int rsl = -1; // если элемента нет в массиве, то возвращаем -1.

        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
