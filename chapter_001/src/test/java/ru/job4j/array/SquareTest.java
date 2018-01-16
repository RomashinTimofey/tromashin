package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class Test Square
 */
public class SquareTest {
    /**
     * TestMethod for bound 3
     */
    @Test
    public void when3squaredRsl9() {
        Square square = new Square();
        int bound = 3;
        int[] squareNumber = square.calculate(bound);
        int rsl = squareNumber[bound - 1];
        assertThat(rsl, is(9));
    }


    /**
     * TestMethod for bound 13
     */
    @Test
    public void when13squaredRs169() {
        Square square = new Square();
        int bound = 13;
        int[] squareNumber = square.calculate(bound);
        int rsl = squareNumber[bound - 1];
        assertThat(rsl, is(169));
    }
}
