package ru.job4j.controltest;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitedSortedArrayTest {
    @Test
    public void whenSecondArraylessFirstThen() {
        UnitedSortedArray unitedSortedArray = new UnitedSortedArray();
        int[] result = unitedSortedArray.sortedArrays(new int[]{1, 4, 5}, new int[]{2, 3});
        int[] excepted = {1, 2, 3, 4, 5};
        assertThat(result, is(excepted));
    }

    @Test
    public void whenFirstArraylessSecondThen() {
        UnitedSortedArray unitedSortedArray = new UnitedSortedArray();
        int[] result = unitedSortedArray.sortedArrays(new int[]{3, 5}, new int[]{1, 2, 4});
        int[] excepted = {1, 2, 3, 4, 5};
        assertThat(result, is(excepted));
    }
}
