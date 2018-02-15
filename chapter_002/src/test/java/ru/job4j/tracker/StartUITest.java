package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * Test add 0
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test edit 2
     */
    @Test
    public void whenEditThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        String result = "name1";
        Input input = new StubInput(new String[]{"2", item.getId(), result, "decs", "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is(result));
    }

}
