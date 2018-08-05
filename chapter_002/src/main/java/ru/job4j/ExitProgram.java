package ru.job4j;

public class ExitProgram implements UserActions{
    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return null;
    }
}
