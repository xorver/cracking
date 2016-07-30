package ex614;

import utils.Point;

public class VectorOperations {

    public static Point subtract(Point p1, Point p2) {
        return new Point(p1.x - p2.x, p1.y - p2.y);
    }

    public static double scalar_product(Point base, Point p1, Point p2) {
        Point pb1 = subtract(p1, base);
        Point pb2 = subtract(p2, base);
        return pb1.x * pb2.x + pb1.y * pb2.y;
    }

    public static double vector_product(Point base, Point p1, Point p2) {
        Point pb1 = subtract(p1, base);
        Point pb2 = subtract(p2, base);
        return pb1.x * pb2.y - pb1.y * pb2.x;
    }
}
