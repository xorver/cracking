package ex622;

import java.nio.channels.Pipe;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point){
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.x*32 ^ this.y;
    }
}
