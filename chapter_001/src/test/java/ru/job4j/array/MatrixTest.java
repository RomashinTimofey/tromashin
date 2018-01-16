package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenSize2ThenhMultiplieTable2v2() {
        Matrix matrix = new Matrix();
        int[][] rsl = matrix.multiple(2);
        int[][] excepted = {{1, 2}, {2, 4}};
        assertThat(rsl, is(excepted));
    }

    @Test
    public void when3x3then9() {
        Matrix matrix = new Matrix();
        int[][] rsl = matrix.multiple(4);
        int result = rsl[1][1];
        assertThat(result, is(4));
    }

}
