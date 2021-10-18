package lab5;

public class StringHelper {
    public static void main(String[] args) {
        System.out.println(initials("Jacob Duba"));
        System.out.println(initials("Cher cher Cher"));
        System.out.println(initials("Cher"));
        System.out.println(findVowel("Hello world!"));
        System.out.println(findVowel("Lmlll"));
    }

    public static String initials(String s) {
        String initials = "";
        initials += s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                initials += s.charAt(i + 1);
            }
        }
        return initials;
    }

    public static int findVowel(String s) {
        for (int i = 0; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0) {
                return i;
            }
        }
        return -1;
    }
}
