package ru.job4j.strategyPattern;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        String ln = System.lineSeparator();
        String result = new StringBuilder()
                .append("+")
                .append(ln)
                .append("+ +")
                .append(ln)
                .append("+  +")
                .append(ln)
                .append("+++++").toString();
        assertThat(triangle.pic(), is(result));
    }
}