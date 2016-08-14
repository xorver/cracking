package ex1614;

import utils.Point;

public class VectorOperations {

    private static final double EPSILON = 10e-10;

    public static Point subtract(Point p1, Point p2) {
        return new Point(p1.x - p2.x, p1.y - p2.y);
    }

    public static double scalarProduct(Point base, Point p1, Point p2) {
        Point pb1 = subtract(p1, base);
        Point pb2 = subtract(p2, base);
        return pb1.x * pb2.x + pb1.y * pb2.y;
    }

    public static double vectorProduct(Point base, Point p1, Point p2) {
        Point pb1 = subtract(p1, base);
        Point pb2 = subtract(p2, base);
        return pb1.x * pb2.y - pb1.y * pb2.x;
    }

    public static boolean isZero(double d) {
        return Math.abs(d) < EPSILON;
    }
}
