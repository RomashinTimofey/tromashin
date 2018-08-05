package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserActions> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new MenuTracker.AddAction());
        this.actions.add(new MenuTracker.ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new MenuTracker.FindItemById());
        this.actions.add(new MenuTracker.FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(String key) {
        int conKeys = Integer.parseInt(key);
        this.actions.get(conKeys).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserActions action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + " " + action.info());
            }
        }
    }


    /**
     * Class "Add item"
     */
    public class AddAction implements UserActions {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public String info() {
            return "Add new Item.";
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }
    }


    private class ShowItems implements UserActions {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Show all items --------------");
            for (Item item : tracker.findAll()) {
                System.out.println("Item name: " + item.getName());
                System.out.println("Item id: " + item.getId());
                System.out.println("Item description: " + item.getDescription() + "\n");

            }
        }

        @Override
        public String info() {
            return "Show items";
        }
    }

    private class EditItem implements UserActions {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Edit item --------------");
            String itemID = input.ask("Please, provide item id:");
            String name = input.ask("Please, provide new item name:");
            String desc = input.ask("Please, provide new item description:");
            Item item = new Item(name, desc);
            tracker.replace(itemID, item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }

        @Override
        public String info() {
            return "Edit item";
        }
    }

    private class DeleteItem implements UserActions {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item --------------");
            String itemID = input.ask("Please, provide item id:");
            tracker.delete(itemID);
            System.out.println("------------ Item was deleted --------------");
        }

        @Override
        public String info() {
            return "Delete item";
        }
    }

    private class FindItemById implements UserActions {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by Id --------------");
            String itemID = input.ask("Please, provide item id:");
            Item item = tracker.findById(itemID);
            System.out.println("------------ Item with Id : " + item.getId());
            System.out.println("------------ Item with Name : " + item.getName());
            System.out.println("------------ Item with Description : " + item.getDescription());
        }

        @Override
        public String info() {
            return "Find item by ID";
        }
    }

    private static class FindItemsByName implements UserActions {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by name --------------");
            String itemName = input.ask("Please, provide item name:");
            tracker.findByName(itemName);
            for (Item item : tracker.findByName(itemName)) {
                System.out.println("Item name: " + item.getName());
                System.out.println("Item id: " + item.getId());
                System.out.println("Item description: " + item.getDescription() + "\n");

            }
        }

        @Override
        public String info() {
            return "Find item by name";
        }
    }
}
