package ru.job4j.professions;

public class Engineer extends Profession {
    private boolean hasPencil;
    private boolean planAccepted;

    public Engineer(String name, String position, boolean healthy, boolean compliance, boolean trained, boolean hasPencil) {
        super(name, position, healthy, compliance, trained);
        this.hasPencil = hasPencil;
    }

    void develop(Profession member) {
        planAccepted = this.isCompliance() && member.isCompliance();
    }
}
