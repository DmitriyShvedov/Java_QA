package ru.shvedov.plane;

public class PointMain  {

    public static void main(String[] args) {

        Point p1 = new Point(1,2);
        Point p2 = new Point(2, 1);


        System.out.println(p2.distance(p1));

    }
}
