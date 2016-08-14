package ex1622;


import java.util.*;

public class Ex622 {

    public static void printKMoves(int k) {
        Map<Point, String> board = new HashMap<>();
        int turn = 1;
        Point position = new Point(0, 0);

        for (int i = 0; i < k; i++) {
            String color = board.getOrDefault(position, "white");
            if (color.equals("white")) {
                board.put(position, "black");
                turn = (turn + 1) % 4;
            } else {
                board.remove(position);
                turn = (turn - 1) % 4;
                turn = turn < 0 ? turn + 4 : turn;
            }
            position = move(position, turn);
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(Map.Entry<Point, String> entry : board.entrySet()) {
            minX = Integer.min(entry.getKey().x, minX);
            minY = Integer.min(entry.getKey().y, minY);
            maxX = Integer.max(entry.getKey().x, maxX);
            maxY = Integer.max(entry.getKey().y, maxY);
        }
        for(int i=maxY; i>=minY; i--) {
            for (int j = minX; j <= maxX; j++)
                if (board.containsKey(new Point(j, i)))
                    System.out.print(1);
                else
                    System.out.print(0);
            System.out.println();
        }
    }

    private static Point move(Point position, int turn) {
        switch (turn) {
            case 0:
                return new Point(position.x, position.y + 1);
            case 1:
                return new Point(position.x + 1, position.y);
            case 2:
                return new Point(position.x, position.y - 1);
            case 3:
                return new Point(position.x - 1, position.y);
        }
        return null;
    }

    public static void main(String[] args) {
        printKMoves(1000);
    }
}
