package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    /**
     * Test findAll method & add method
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test replace method
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test findByName method
     */
    @Test
    public void whenFindbyNameResultIsName() {
        Item itemOfZeroIndex = new Item("ImFirst", "testDescription", 123L);
        Item itemOfFirstIndex = new Item("ImSecond", "testDescription2", 1234L);
        Item itemOfSecondIndex = new Item("ImThird", "testDescription3", 12345L);
        Item itemOfThirdIndex = new Item("ImSecond", "testDescription3", 12345L);
        Tracker tracker = new Tracker();
        tracker.add(itemOfZeroIndex);
        tracker.add(itemOfFirstIndex);
        tracker.add(itemOfSecondIndex);
        tracker.add(itemOfThirdIndex);
        Item[] items = tracker.findByName("ImSecond");
        assertThat(items[0].getName(), is("ImSecond"));
        assertThat(items[1].getName(), is("ImSecond"));
    }

    /**
     * Test findByName method
     */
    @Test
    public void whenFindByIdResultIsName() {
        Item itemOfZeroIndex = new Item("ImFirst", "testDescription", 123L);
        Item itemOfFirstIndex = new Item("ImSecond", "testDescription2", 1234L);
        Item itemOfSecondIndex = new Item("ImThird", "testDescription3", 12345L);
        Item itemOfThirdIndex = new Item("ImFour", "testDescription3", 12345L);
        Tracker tracker = new Tracker();
        tracker.add(itemOfZeroIndex);
        tracker.add(itemOfFirstIndex);
        tracker.add(itemOfSecondIndex);
        tracker.add(itemOfThirdIndex);
        itemOfSecondIndex.setId("thisSetId");
        Item item = tracker.findById("thisSetId");
        assertThat(item.getId(), is("thisSetId"));
    }

    /**
     * Test delete method
     */
    @Test
    public void whenDeleteResultIsArrayWihtoutElement() {
        Item itemOfZeroIndex = new Item("ImFirst", "testDescription", 123L);
        Item itemOfFirstIndex = new Item("ImSecond", "testDescription2", 1234L);
        Item itemOfSecondIndex = new Item("ImThird", "testDescription3", 12345L);
        Item itemOfThirdIndex = new Item("ImFour", "testDescription3", 12345L);
        Tracker tracker = new Tracker();
        tracker.add(itemOfZeroIndex);
        tracker.add(itemOfFirstIndex);
        tracker.add(itemOfSecondIndex);
        tracker.add(itemOfThirdIndex);
        itemOfSecondIndex.setId("thisSetId");
        tracker.delete("thisSetId");
        Item[] items = tracker.getItems();
        assertThat(items[2].getName(), is("ImFour"));
    }

    /**
     * Test generateId method
     */
    @Test
    public void whenGenerateIdResultIsGeneratedId() {
        Item itemOfZeroIndex = new Item("ImFirst", "testDescription", 123L);
        Item itemOfFirstIndex = new Item("ImSecond", "testDescription2", 1234L);
        Tracker tracker = new Tracker();
        tracker.add(itemOfZeroIndex);
        tracker.add(itemOfFirstIndex);
        Item[] items = tracker.getItems();
        assertThat(items[0].getId() != null, is(items[0].getId() != null));
    }

}
