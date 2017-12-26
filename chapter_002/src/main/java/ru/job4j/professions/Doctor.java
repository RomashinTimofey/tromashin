package ru.job4j.professions;

public class Doctor extends Profession{
    boolean hasScalpel;
    void heal(Profession member) {
        member.healthy = true;
    }
}
