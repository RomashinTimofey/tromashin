package ru.job4j.professions;

public class Teacher extends Profession {
    private boolean hasPointer;

    public Teacher(String name, String position, boolean healthy, boolean compliance, boolean trained, boolean hasPointer) {
        super(name, position, healthy, compliance, trained);
        this.hasPointer = hasPointer;
    }

    String teached(Profession member) {
        member.setTrained(true);
        return member.getName() + " is trained";
    }
}
