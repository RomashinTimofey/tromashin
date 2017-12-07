package ru.job4j.max;

/**
 *	Class for calculate max of 2 numbers
 *	@author tromashin
 *	@since 06.12.2017
 *	@version 1
 */
public class Max {
    /**
     *
     * @param first is first calculatable number
     * @param second is second calculatable number
     * @return maximum of calculatable numbers
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}