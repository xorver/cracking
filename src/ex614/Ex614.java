package ex614;


import utils.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Ex614 {

    public static Collection<Point> largest_line(List<Point> points) {
        List<Point> currentPoints;
        List<Point> bestPoints = new ArrayList<>();

        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++) {
                currentPoints = new ArrayList<>();
                currentPoints.add(points.get(i));
                currentPoints.add(points.get(j));
                for (int k = j+1; k< points.size(); k++)
                    if(VectorOperations.vector_product(points.get(i), points.get(j), points.get(k)) == 0){
                        currentPoints.add(points.get(k));
                        if(currentPoints.size() > bestPoints.size())
                            bestPoints = currentPoints;
                    }
            }
        return bestPoints;
    }

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(1, 1),
                new Point(5, 1),
                new Point(6, 9),
                new Point(2, 3),
                new Point(3, 4),
                new Point(6, 7),
                new Point(4, 6),
                new Point(1, 2),
                new Point(1, 7)
        );

        System.out.println(largest_line(points));
    }
}
