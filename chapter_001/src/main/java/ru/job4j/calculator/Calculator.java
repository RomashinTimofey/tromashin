package ru.job4j.calculator;

/**
 *	Class for arithmetic operations
 *	@author tromashin
 *	@since 04.12.2017
 *	@version 1
 */

public class Calculator {
    private double result;

    /**
     * 	Method add.
     * 	@param first is 1st value for summary 2 numbers
     * 	@param second is 2nd value for summary 2 numbers
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * 	Method substract.
     * 	@param first is 1st value for substract 2 numbers
     * 	@param second is 2nd value for subsctract 2 numbers
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * 	Method div.
     * 	@param first is 1st value for div 2 numbers
     * 	@param second is 2nd value for div 2 numbers
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * 	Method multiple.
     * 	@param first is 1st value for multiple 2 numbers
     * 	@param second is 2nd value for multiple 2 numbers
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * 	Method getResult.
     * 	@return value of result
     */
    public double getResult() {
        return this.result;
    }
}
