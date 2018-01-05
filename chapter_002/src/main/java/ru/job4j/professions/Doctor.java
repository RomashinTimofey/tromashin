package ru.job4j.professions;

public class Doctor extends Profession {
    private boolean hasScalpel;

    public Doctor(String _name, String _position, boolean _healthy, boolean _compliance, boolean _trained, boolean hasScalpel) {
        super(_name, _position, _healthy, _compliance, _trained);
        this.hasScalpel = hasScalpel;
    }

    void heal(Profession member) {
        member.setHealthy(true);
    }
}
