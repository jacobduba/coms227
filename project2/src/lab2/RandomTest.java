package lab2;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random rand = new Random(137);
        System.out.println(rand.nextInt(4));
        System.out.println(rand.nextInt(4));
        System.out.println(rand.nextInt(4));
        System.out.println(rand.nextInt(4));
    }
}
