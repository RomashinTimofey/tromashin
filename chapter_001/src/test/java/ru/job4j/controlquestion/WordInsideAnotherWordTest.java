package ru.job4j.controlquestion;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordInsideAnotherWordTest {
    @Test
    public void whenWordInWordThenTrue() {
        WordInsideAnotherWord word = new WordInsideAnotherWord();
        boolean result = word.contains("привет", "иве");
        assertThat(result, is(true));
    }

    @Test
    public void whenWordNotIWordThenFalse() {
        WordInsideAnotherWord word = new WordInsideAnotherWord();
        boolean result = word.contains("привет", "пиве");
        assertThat(result, is(false));
    }
}
