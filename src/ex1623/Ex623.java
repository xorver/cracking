package ex1623;

import java.util.Random;

public class Ex623 {

    public static int rand7() {
        Random random = new Random();
        int randInt = random.nextInt(5) * 10 + random.nextInt(5);

        if(randInt >= 41)
            return rand7();
        return randInt % 7;
    }

    public static void main(String[] args) {
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());
    }
}
