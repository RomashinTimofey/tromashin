package ru.job4j.professions;

public class Teacher extends Profession {
    boolean hasPointer;

    String teached(Profession member) {
        member.trained = true;
        return member.getName() +" is trained";
    }
}
