package ex1708;

public class Person {
    public int w;
    public int h;

    public Person(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Person{" +
                "w=" + w +
                ", h=" + h +
                '}';
    }
}
