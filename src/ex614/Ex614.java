package ex614;


import utils.Line;
import utils.Point;

import java.util.*;

public class Ex614 {

    public static Collection<Point> largestLine(List<Point> points) {
        List<Point> currentPoints;
        List<Point> bestPoints = new ArrayList<>();

        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++) {
                currentPoints = new ArrayList<>();
                currentPoints.add(points.get(i));
                currentPoints.add(points.get(j));
                for (int k = j+1; k < points.size(); k++)
                    if(VectorOperations.vectorProduct(points.get(i), points.get(j), points.get(k)) == 0){
                        currentPoints.add(points.get(k));
                        if(currentPoints.size() > bestPoints.size())
                            bestPoints = currentPoints;
                    }
            }
        return bestPoints;
    }

    public static Line largestLineFast(List<Point> points) {
        Map<Line, Integer> lines = new HashMap<>();
        for (int i = 0; i < points.size(); i++)
            for (int j = i + 1; j < points.size(); j++) {
                Line line = new Line(points.get(i), points.get(j));
                lines.put(line, lines.getOrDefault(line, 0) + 1);
            }
        Line bestLine = null;
        int bestQuantity = 0;
        for (Map.Entry<Line, Integer> entry: lines.entrySet())
            if(entry.getValue() > bestQuantity) {
                bestLine = entry.getKey();
                bestQuantity = entry.getValue();
            }
        return bestLine;
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

        System.out.println(largestLine(points));
        System.out.println(largestLineFast(points));
    }
}
