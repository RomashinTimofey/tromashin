package ru.job4j.professions;

public class Engineer extends Profession {
    private boolean hasPencil;
    private boolean planAccepted;

    public Engineer(String _name, String _position, boolean _healthy, boolean _compliance, boolean _trained, boolean hasPencil) {
        super(_name, _position, _healthy, _compliance, _trained);
        this.hasPencil = hasPencil;
    }

    void develop(Profession member) {
        planAccepted = this.isCompliance() && member.isCompliance();
    }
}
