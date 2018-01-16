package ru.job4j.professions;

public class Doctor extends Profession {
    private boolean hasScalpel;

    public Doctor(String name, String position, boolean healthy, boolean compliance, boolean trained, boolean hasScalpel) {
        super(name, position, healthy, compliance, trained);
        this.hasScalpel = hasScalpel;
    }

    void heal(Profession member) {
        member.setHealthy(true);
    }
}
