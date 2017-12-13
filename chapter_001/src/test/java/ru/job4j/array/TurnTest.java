package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Turn class
 */
public class TurnTest {

    /**
     * test method back(int[]) with evenLength of Array
     */
    @Test
    public void whenArrayEvenLength() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{0,1,2,3,4,5});
        assertThat(result, is(new int[] {5,4,3,2,1,0}));
    }

    /**
     * test method back(int[]) with oddLength of Array
     */
    @Test
    public void whenArrayOddLength() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{0,1,2,3,4});
        assertThat(result, is(new int[] {4,3,2,1,0}));
    }

}
