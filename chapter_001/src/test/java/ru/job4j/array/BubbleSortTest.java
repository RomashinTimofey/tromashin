package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    /**
     * test method sort(int[]) with evenLength of Array
     */
    @Test
    public void whenArrayEvenLength() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(new int[]{5, 1, 2, 7, 3});
        assertThat(result, is(new int[] {1,2,3,5,7}));
    }

    /**
     * test method sort(int[]) with oddLength of Array
     */
    @Test
    public void whenArrayOddLength() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(new int[]{5, 1, 2, 7, 3,4});
        assertThat(result, is(new int[] {1,2,3,4,5,7}));
    }
}
