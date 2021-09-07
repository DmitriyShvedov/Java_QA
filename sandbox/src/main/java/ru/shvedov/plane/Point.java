package ru.shvedov.plane;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public  double distance(Point p){
        return Math.sqrt((Math.pow(2,(this.x - p.x))) + (Math.pow(2,(this.y - p.y))));
    }

}
