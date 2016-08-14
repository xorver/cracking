package ex1619;


import utils.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1619 {

    public static void addResult(List<Integer> result, int index, int value) {
        result.set(Math.abs(index), result.get(Math.abs(index)) + value);
    }

    public static Collection<Integer> pondSize(int[][] matrix){
        List<Pair<Integer, Integer>> toMerge = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int h = matrix.length;
        if (h == 0)
            return result;
        int w = matrix[0].length;
        int[] previous = new int[w];
        int[] actual = new int[w];

        result.add(0);
        for(int i=0; i<h; i++) {
            for (int j = 0; j < w; j++) {
                int left = j - 1 >= 0 ? previous[j - 1] : 1;
                int up = previous[j];
                int right = j + 1 < w ? previous[j + 1] : 1;
                if (matrix[i][j] > 0)
                    actual[j] = matrix[i][j];
                else {
                    if (up < 0) {
                        actual[j] = up;
                        addResult(result, up, 1);
                    } else if (left < 0 && right < 0) {
                        actual[j] = left;
                        addResult(result, left, 1);
                        if (left != right)
                            toMerge.add(new Pair<>(-left, -right));
                    } else if (left < 0) {
                        actual[j] = left;
                        addResult(result, left, 1);
                    } else if (right < 0) {
                        actual[j] = right;
                        addResult(result, right, 1);
                    } else {
                        actual[j] = -result.size();
                        result.add(1);
                    }
                    if (j != 0 && actual[j - 1] < 0 && actual[j] < 0 && actual[j - 1] != actual[j])
                        toMerge.add(new Pair<>(-actual[j], -actual[j - 1]));
                }
            }
            previous = actual;
        }

        for(Pair<Integer, Integer> p: toMerge)
            merge(result, p.first, p.second);
        return result.stream().filter(x -> x>0).collect(Collectors.toList());
    }

    private static void merge(List<Integer> result, Integer first, Integer second) {
        int firstValue = result.get(first);
        int secondValue = result.get(second);
        if(firstValue < 0)
            merge(result, -firstValue, second);
        if(secondValue < 0)
            merge(result, first, -secondValue);
        result.set(first, firstValue + secondValue);
        result.set(second, -first);
    }

    public static void main(String[] args) {

        int [][] terrain = new int[][] {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1},
        };
        System.out.println(pondSize(terrain));
    }
}
