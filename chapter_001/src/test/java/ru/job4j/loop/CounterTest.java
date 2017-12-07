package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    /**
     * Test Counter.add
     */
    @Test
    public void whenStartOneEndTenThenResultSumOfModTwo() {
        int result = new Counter().add(1,10);
        assertThat(result, is(30));
    }
}
