package ru.job4j.strategyPattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String ln = System.lineSeparator();
        String result = new StringBuilder()
                .append("+++++")
                .append(ln)
                .append("+   +")
                .append(ln)
                .append("+   +")
                .append(ln)
                .append("+++++").toString();
        assertThat(square.pic(), is(result));
    }
}
