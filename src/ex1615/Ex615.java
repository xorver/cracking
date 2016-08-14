package ex1615;

import java.util.HashMap;
import java.util.Map;

public class Ex615 {

    public static Score getScore(String actual, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        Score score = new Score();
        for(int i = 0; i < actual.length(); i++)
            if(actual.charAt(i) == guess.charAt(i))
                score.hit++;
            else
                map.put(actual.charAt(i), map.getOrDefault(actual.charAt(i), 0) + 1);

        for(int i = 0; i < actual.length(); i++)
            if(actual.charAt(i) != guess.charAt(i) && map.getOrDefault(guess.charAt(i), 0) > 0) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                score.pseudoHit++;
            }
        return score;
    }

    public static void main(String[] args) {

        System.out.println(getScore("RGBY", "GGRR"));
    }
}
