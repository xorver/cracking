package ex1617;

import java.util.Arrays;
import java.util.List;

public class Ex1617 {

    public static int largestSequence(List<Integer> list) {
        int best = 0;
        int actual = 0;
        for(Integer i: list) {
            actual = Math.max(0, actual + i);
            best = Math.max(best, actual);
        }
        return best;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, -8, 3, -2, 4, -10);

        System.out.println(largestSequence(list));
    }
}
