package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] result = new ArrayDuplicate().remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] excepted = {"Привет", "Мир", "Супер"};
        assertThat(result, is(excepted));
    }

}
