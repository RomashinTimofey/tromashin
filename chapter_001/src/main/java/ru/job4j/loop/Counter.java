package ru.job4j.loop;

/**
 *	Class Counter
 *	@author tromashin
 *	@since 07.12.2017
 *	@version 1
 */
public class Counter {

    /**
     * 	Method add
     * 	@param start is start summary of %2 numbers
     * 	@param finish is end summary of %2 numbers
     * 	@return summary of %2 numbers
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                sum += start;
            }
        }
        return sum;
    }
}
