package ex1611;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex1611 {

    public static Set<Integer> all_lengths(int s, int l, int k) {
        if(k == 0) {
            return new HashSet<>(Collections.singletonList(0));
        }
        Set<Integer> result = all_lengths(s, l, k - 1);
        return result.stream().flatMap(i -> Stream.of(i + l, i + s)).collect(Collectors.toSet());
    }


    public static Set<Integer> fast_all_lengths(int s, int l, int k) {
        int diff = l - s;
        int base = s * k;
        return IntStream.range(0, k + 1).map(i -> base + i * diff).boxed().collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println(all_lengths(3, 4, 3));
        System.out.println(fast_all_lengths(3, 4, 3));
    }
}
