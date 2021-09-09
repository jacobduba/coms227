package lab2;

import java.util.Locale;
import java.util.Random;

public class StringMethod {
    public static void main(String[] args) {
        String message;

        message = "Hello world!";
        System.out.println(message);

        int theLength = message.length();
        System.out.println(theLength);

        char theChar = message.charAt(0);
        System.out.println(theChar);

        theChar = message.charAt(1);
        System.out.println(theChar);

        // Largest index you can get without error
        theChar = message.charAt(11);
        System.out.println(theChar);

        System.out.println(message.toUpperCase());

        System.out.println(message.substring(0, 5));

        Random rand = new Random(137);
        System.out.println(rand.nextInt(6));
        System.out.println(rand.nextInt(6));
        System.out.println(rand.nextInt(6));
        System.out.println(rand.nextInt(6));
    }
}
