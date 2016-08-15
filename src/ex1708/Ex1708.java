package ex1708;

import java.util.*;

public class Ex1708 {

    private static List<Person> highestTower(Collection<Person> people) {
        List<Person> sorted = new ArrayList<>(people);
        Collections.sort(sorted, (p1, p2) -> Integer.valueOf(p1.w).compareTo(p2.w));
        Value[] bestValue = new Value[sorted.size()];
        Value best = new Value(-1, 0);

        for (int i = 0; i < sorted.size(); i++) {
            bestValue[i] = new Value(-1, 1);
            for (int j = 0; j < i; j++) {
                if (sorted.get(j).w < sorted.get(i).w &&
                        sorted.get(j).h < sorted.get(i).h &&
                        bestValue[j].score >= bestValue[i].score) {
                    bestValue[i].index = j;
                    bestValue[i].score = bestValue[j].score + 1;
                }
            }
            if (best.score < bestValue[i].score) {
                best.index = i;
                best.score = bestValue[i].score;
            }
        }

        List<Person> result = new ArrayList<>();
        while (best.index != -1) {
            result.add(sorted.get(best.index));
            best.index = bestValue[best.index].index;
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<Person> people = Arrays.asList(
                new Person(4, 4),
                new Person(3, 4),
                new Person(3, 3),
                new Person(2, 6),
                new Person(7, 1),
                new Person(2, 1),
                new Person(1, 2),
                new Person(1, 3)
        );
        System.out.println(highestTower(people));
    }
}
