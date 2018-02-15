package ru.job4j.strategyPattern;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
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
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}
