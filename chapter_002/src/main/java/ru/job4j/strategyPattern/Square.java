package ru.job4j.strategyPattern;

public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        String ln = System.lineSeparator();
        pic.append("+++++");
        pic.append(ln);
        pic.append("+   +");
        pic.append(ln);
        pic.append("+   +");
        pic.append(ln);
        pic.append("+++++");
        return pic.toString();
    }
}
