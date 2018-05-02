package ru.job4j.strategyPattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }


    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // результат ожидания
        String ln = System.lineSeparator();
        String result = new StringBuilder()
                .append("+++++")
                .append(ln)
                .append("+   +")
                .append(ln)
                .append("+   +")
                .append(ln)
                .append("+++++")
                .append(ln)
                .toString();
        // проверяем результат вычисления
        assertThat(new String(out.toByteArray()), is(result));

    }


    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        String ln = System.lineSeparator();
        String result = new StringBuilder()
                .append("+")
                .append(ln)
                .append("+ +")
                .append(ln)
                .append("+  +")
                .append(ln)
                .append("+++++")
                .append(ln)
                .toString();
        assertThat(new String(this.out.toByteArray()), is(result));
    }


    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

//    @Test
//    public void whenDrawSquare() {
//        new Paint().draw(new Square());
//        assertThat(
//                new String(this.out.toByteArray()),
//                is(
//                        new StringBuilder()
//                                .append("++++")
//                                .append("+     +")
//                                .append("+     +")
//                                .append("++++")
//                                .append(System.lineSeparator())
//                                .toString()
//                )
//        );
//    }
//
//    @Test
//    public void whenDrawTriangle() {
//        new Paint().draw(new Triangle());
//        assertThat(
//                new String(this.out.toByteArray()),
//                is(
//                        new StringBuilder(
//                                System.lineSeparator(), "",
//                                System.lineSeparator())
//                                .add("  ^  ")
//                                .add(" ^ ^ ")
//                                .add("^^^^^")
//                                .toString()
//                )
//        );
//    }
}
