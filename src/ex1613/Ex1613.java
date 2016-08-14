package ex1613;

import utils.Line;
import utils.Point;

public class Ex1613 {

    public static Line find_half_split_line(Square sq1, Square sq2) {

        return new Line(
                new Point(sq1.left_down.x + sq1.length / 2, sq1.left_down.y + sq1.length / 2),
                new Point(sq2.left_down.x + sq2.length / 2, sq2.left_down.y + sq2.length / 2)
        );
    }

    public static void main(String[] args) {
//        Square sq1 = new Square(new Point(0, 0), 5);
//        Square sq2 = new Square(new Point(7, 9), 3);
        Square sq1 = new Square(new Point(0, 0), 3);
        Square sq2 = new Square(new Point(0, 1), 3);

        System.out.println(find_half_split_line(sq1, sq2));
        System.out.println(find_half_split_line(sq1, sq2).toEquationFormatString());
    }
}
