package ru.job4j.max;

/**
 * Class for calculate max of 2 numbers
 *
 * @author tromashin
 * @version 1
 * @since 06.12.2017
 */
public class Max {
    /**
     * @param first  is first calculatable number
     * @param second is second calculatable number
     * @return maximum of calculatable numbers
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * @param first  is first calculatable number
     * @param second is second calculatable number
     * @param third  is third calculatable number
     * @return maximum of calculatable numbers
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
