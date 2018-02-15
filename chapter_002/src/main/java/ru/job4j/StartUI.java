package ru.job4j;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * константа для отображения существующих заявок
     */
    private static final String SHOW_ALL_ITEMS = "1";

    /**
     * Константа для изменения существующей заявки
     */
    private static final String EDIT_ITEM = "2";
    /**
     * константа для удаления заявки
     */
    private static final String DELETE_ITEM = "3";
    /**
     * Константа для поиска заявки по Id
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа для поиска заявки по названию
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL_ITEMS.equals(answer)) {
                this.showItems();
            } else if (EDIT_ITEM.equals(answer)) {
                this.replaceItem();

            } else if (DELETE_ITEM.equals(answer)) {
                this.deleteIdItem();

            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Нет соответствующего пункта меню \n");
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите определение заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с идентификатором : " + item.getId() + "-----------");
    }

    /**
     * Метод для вывода существующих заявок
     */
    private void showItems() {
        System.out.println("------------ Результат поиска заявок --------------");
        Item[] result = this.tracker.findAll();
        for (Item item : result) {
            System.out.println();
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Определение заявки: " + item.getDescription());
            System.out.println("Идентификатор заявки: " + item.getId());

        }
    }

    /**
     * Метод для изменения существующей заявки
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование существующей заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        Item result = this.tracker.findById(id);
        System.out.println("Следующая заявка будет изменена");
        System.out.println("Имя заявки: " + result.getName());
        System.out.println("Определение заявки: " + result.getDescription());
        System.out.println("Идентификатор заявки: " + result.getId());

        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое определение заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("Заявка изменана!");

    }

    /**
     * Метод для удаление заявки
     */
    private void deleteIdItem() {
        System.out.println("------------ Удаление существующей заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        Item result = this.tracker.findById(id);
        System.out.println("Следующая заявка удалена");
        System.out.println("Имя заявки: " + result.getName());
        System.out.println("Определение заявки: " + result.getDescription());
        System.out.println("Идентификатор заявки: " + result.getId());
        this.tracker.delete(id);
    }

    private void findItemById() {
        System.out.println("------------ Поиск заявки по идентификатору --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        Item result = this.tracker.findById(id);
        if (result.getName() != null) {
            System.out.println("------------ Результат поиска:  --------------");
            System.out.println("Имя заявки: " + result.getName());
            System.out.println("Определение заявки: " + result.getDescription());
            System.out.println("Идентификатор заявки: " + result.getId());
        } else {
            System.out.println("------------ Указанного идентификатора не существует --------------");
        }
    }

    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите название заявки :");
        Item[] result = this.tracker.findByName(name);
        if (result.length > 0) {
            for (Item item : result) {
                System.out.println("------------ Результат поиска:  --------------");
                System.out.println("Имя заявки: " + item.getName());
                System.out.println("Определение заявки: " + item.getDescription());
                System.out.println("Идентификатор заявки: " + item.getId());
            }
        } else {
            System.out.println("------------ Совпаделий не найдено --------------");
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 Add new item");
        System.out.println("1 Show all items");
        System.out.println("2 Edit item");
        System.out.println("3 Delete item");
        System.out.println("4 Find item by Id");
        System.out.println("5 Find item by name");
        System.out.println("6 Exit program");
    }

    /**
     * Запускт программы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
