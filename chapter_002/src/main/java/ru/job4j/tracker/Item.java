package ru.job4j.tracker;

public class Item {
    private String id;
    public String name;
    public String description;
    public long create;

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreate() {
        return create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


}
