package ru.job4j.strategyPattern;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
