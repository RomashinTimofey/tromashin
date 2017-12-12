package ru.job4j.array;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class FindLoopTest {

    /**
     * Test el = 4 index = 2
     */
    @Test
    public void whenEl4getIndex2() {
        int[] data = {0,1,4,3,2,5};
        FindLoop FL = new FindLoop();
        int rsl = FL.indexOf(data, 4);
        assertThat(rsl, is(2));
    }

    /**
     * Test el=13 index not found(-1)
     */
    @Test
    public void whenEl13getMinus1() {
        int[] data = {0,1,2,3,4,5};
        FindLoop FL = new FindLoop();
        int rsl = FL.indexOf(data, 13);
        assertThat(rsl, is(-1));
    }
}
