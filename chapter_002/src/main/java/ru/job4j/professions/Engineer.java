package ru.job4j.professions;

public class Engineer extends Profession {
    boolean hasPencil;
    private boolean planAccepted;

    void develop(Profession member) {
        if (this.compliance && member.compliance) {
            planAccepted = true;
        } else planAccepted = false;
    }
}
