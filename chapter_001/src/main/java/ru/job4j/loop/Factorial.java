package ru.job4j.loop;

/**
 *	Class Factorial
 *	@author tromashin
 *	@since 07.12.2017
 *	@version 1
 */

public class Factorial {

    /**
     * 	Method calc
     * 	@param n is number for factorial calc
     * 	@return factorial of n number
     */

    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
