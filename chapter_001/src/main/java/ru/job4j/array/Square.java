package ru.job4j.array;

/**
 * Class for calculate SquareNumber
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     *
     * @param bound value for end SquareNumber
     * @return array of SquareNumbers from 1 to bound value
     */
    public int[] calculate(int bound) {
        int[] rsl = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенные в квадрат
        for (int count=1; count<=bound; count++) {
            rsl[count-1] = count * count;
        }
        return rsl;
    }
}
