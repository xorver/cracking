package ex613;

import utils.Point;

public class Line {
    public Point p1;
    public Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toEquationFormatString() {
        double a = (p1.y - p2.y) / (p1.x - p2.x);
        double b = p1.y - a * p1.x;
        return String.format("y = %fx + %f", a, b);
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
