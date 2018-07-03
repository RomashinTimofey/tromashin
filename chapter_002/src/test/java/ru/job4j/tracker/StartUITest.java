package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private PrintStream stdout;
    private Tracker tracker;
    private Input input;
    private ByteArrayOutputStream out;

    @Before
    public void init() {
        // получаем ссылку на стандартный вывод в консоль.
        stdout = System.out;
        // Создаем буфур для хранения вывода.
        out = new ByteArrayOutputStream();
        tracker = new Tracker();     // создаём Tracker
    }

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Test show all 1
     */
    @Test
    public void whenUserChoiceShowAllCheckResultConsole() {
        input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0 Add new item")
                                .append(System.lineSeparator())
                                .append("1 Show all items")
                                .append(System.lineSeparator())
                                .append("2 Edit item")
                                .append(System.lineSeparator())
                                .append("3 Delete item")
                                .append(System.lineSeparator())
                                .append("4 Find item by Id")
                                .append(System.lineSeparator())
                                .append("5 Find item by name")
                                .append(System.lineSeparator())
                                .append("6 Exit program")
                                .append(System.lineSeparator())
                                .append("------------ Результат поиска заявок --------------")
                                .append(System.lineSeparator())
                                .append("------------ Заявок нет! --------------")
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("0 Add new item")
                                .append(System.lineSeparator())
                                .append("1 Show all items")
                                .append(System.lineSeparator())
                                .append("2 Edit item")
                                .append(System.lineSeparator())
                                .append("3 Delete item")
                                .append(System.lineSeparator())
                                .append("4 Find item by Id")
                                .append(System.lineSeparator())
                                .append("5 Find item by name")
                                .append(System.lineSeparator())
                                .append("6 Exit program")
                                .append(System.lineSeparator())
                                .toString()
                ));
    }

    /**
     * Test add 0
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test edit 2
     */
    @Test
    public void whenEditThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Test delete 3
     */
    @Test
    public void whenDeleteThenTrackerHasDeleteValue() {
        Item forDelItem = tracker.add(new Item());
        Item forSaveItem = tracker.add(new Item());
        String forSaveId = forSaveItem.getId();
        Input input = new StubInput(new String[]{"3", forDelItem.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        int length = tracker.findAll().length;
        assertThat(length, is(1));
        assertThat(forSaveItem.getId(), is(forSaveId));
    }

    /**
     * Test findById 4
     */
    @Test
    public void whenFindByIdThenTrackerHasFindItemThatId() {
        Item item = tracker.add(new Item());
        String result = "name1";
        Input input = new StubInput(new String[]{"2", item.getId(), result, "decs", "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is(result));
    }

}
