package ru.job4j.condition;

/**
 * * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 * Class for calculate S(A,B) of system coordinat
 */
public class Point {
    private int x;
    private int y;

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * method for calculate S(A,B) with points
     * @param that that is second Point.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2)
        );
    }

    public static void main(String[] args) {
        Point a = new Point(6, 1);
        Point b = new Point(2, 4);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
