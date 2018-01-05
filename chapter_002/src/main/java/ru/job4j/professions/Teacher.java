package ru.job4j.professions;

public class Teacher extends Profession {
    private boolean hasPointer;

    public Teacher(String _name, String _position, boolean _healthy, boolean _compliance, boolean _trained, boolean hasPointer) {
        super(_name, _position, _healthy, _compliance, _trained);
        this.hasPointer = hasPointer;
    }

    String teached(Profession member) {
        member.setTrained(true);
        return member.getName() + " is trained";
    }
}
