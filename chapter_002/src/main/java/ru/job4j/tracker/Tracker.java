package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * добавляет заявку, переданную в аргументах в массив заявок this.items
     *
     * @param item новая заявка
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
    }

    /**
     * заменяет ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id
     *
     * @param id   идентификатор перемещаемого
     * @param item заявка для перемещения
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                item.setId(items[index].getId());
                items[index] = item;

            }
        }
    }

    /**
     * удалить ячейку в массиве this.items
     * сместить все значения справа от удаляемого элемента - на одну ячейку влево
     * с помощью System.arrayCopy();
     *
     * @param id идентификатор удаляемой заявки.
     */
    public void delete(String id) {
        int positionOfitems = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                positionOfitems = index;
                position--;
                break;
            }
        }
        Item[] copy = new Item[items.length];
        System.arraycopy(items, 0, items, 0, positionOfitems);
        System.arraycopy(items, positionOfitems + 1, copy, positionOfitems, items.length - positionOfitems - 1);
        items = copy;
    }

    /**
     * возвращает копию массива this.items без null элементов
     *
     * @return массив заявок.
     */
    public Item[] findAll() {
        Item[] copyitems = new Item[position];
        if (copyitems.length > 0) {
            System.arraycopy(items, 0, copyitems, 0, position);
        } else {
            System.out.println("------------ Заявок нет! --------------");
        }
        return copyitems;
    }

    /**
     * проверяет в цикле все элементы массива this.items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода - String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его
     *
     * @param key сравнимый аргумент с именем заявки
     * @return заявка
     */
    public Item[] findByName(String key) {
        int position = 0;
        Item[] resultItems = new Item[100];
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                resultItems[position++] = item;
            }
        }
        return Arrays.copyOf(resultItems, position);
    }

    /**
     * проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     *
     * @param id искомый идентификатор
     * @return заявка по указанному идентификатору
     */
    public Item findById(String id) {
        Item result = new Item();
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item[] getItems() {
        return items;
    }
}

