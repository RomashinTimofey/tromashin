package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test class Point
 */
public class PointTest {
    /**
     * Test method distanceTo
     */
    @Test
    public void whenTakeSecondPointThenGetResultdistanceOfThisThat() {
        Point a = new Point(6,1);
        Point b = new Point(2,4);
        double expect = 5;
        double result = a.distanceTo(b);
        assertThat(result, is(expect));
    }
}
