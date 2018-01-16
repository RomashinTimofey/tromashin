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

public class FactorialTest {

    /**
     * Test method Factorial().calc
     */
    @Test
    public void whenSetNumberNthenGetFactorialN() {
        int result = new Factorial().calc(5);
        assertThat(result, is(120));
    }
}
