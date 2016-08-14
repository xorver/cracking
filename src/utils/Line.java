package utils;

import ex1614.VectorOperations;

public class Line {
    public Point p1;
    public Point p2;
    public double a;
    public double b;
    public double c;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.a = - (p1.y - p2.y);
        this.b = p1.x - p2.x;
        this.c = - p1.y * (p1.x - p2.x) + p1.x * (p1.y - p2.y);
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

    @Override
    public int hashCode() {
        return (int)(this.a + this.b + this.c);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Line))
            return false;
        Line other = (Line) obj;
        if(!VectorOperations.isZero(other.a) && !VectorOperations.isZero(this.a)
                && !VectorOperations.isZero(other.b) && !VectorOperations.isZero(this.b))
            return VectorOperations.isZero(other.b / other.a - this.b / this.a) &&
                    VectorOperations.isZero(other.c / other.a - this.c / this.a);

        if(!VectorOperations.isZero(other.a) && !VectorOperations.isZero(this.a))
            return VectorOperations.isZero(other.c / other.a - this.c / this.a);

        if(!VectorOperations.isZero(other.b) && !VectorOperations.isZero(this.b))
            return VectorOperations.isZero(other.c / other.b - this.c / this.b);
        return false;
    }
}
