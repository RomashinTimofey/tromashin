package ru.job4j.array;

/**
 * Class Matrix
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */

public class Matrix {
    /**
     *
     * @param size of Matrix
     * @return array[][] as Multiplication table
     */
    int[][] multiple(int size) {
        int[][] data = new int[size][size];
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data.length; j++) {
                data[i][j] = (i + 1) * (j + 1);
            }
        }
        return data;
    }
}
