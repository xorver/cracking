package ex1624;

import utils.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Ex624 {

    public static Collection<Pair<Integer, Integer>> pairsWithSum(Collection<Integer> array, int sum) {
        Set<Integer> sumMinusValue = array.stream().map(x -> sum - x).collect(Collectors.toSet());
        return array.stream()
                .filter(sumMinusValue::contains)
                .map(x -> new Pair<>(x, sum - x))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,5,3,5,6,7,3,2,1,4);

        System.out.println(pairsWithSum(list, 6));
    }
}
