package mini1;

import java.util.Scanner;

/**
 * Utility class with a bunch of static methods for loop practice.
 * @author Jacob Duba
 */
public class Looperman
{

  public static void main(String[] args) {
    witchHat(6);
  }

  // disable instantiation
  private Looperman() {}
  
  /**
   * Returns a string obtained from the given string by doubling all the vowels.
   * For example, given the string "Aardvark", the method returns "AAaardvaark".
   * @param s
   *   given string
   * @return
   *   a new string with all vowels doubled
   */
  public static String doubleAllVowels(String s)
  {
    String temp = "";
    for (int i = 0; i < s.length(); i++) {
      char index = s.charAt(i);
      temp += index;
      if ("aeiouAEIOU".indexOf(index) >= 0) {
        temp += index;
      }
    }
    return temp;
  }

  
  /**
   * Returns the number of iterations required until <code>n</code>
   * is equal to 1, where each iteration updates <code>n</code> in the following
   * way:
   * <pre>
   *     if n is even
   *         divide it in half
   *     else
   *         multiply n by three and add 1
   * </pre>
   * For example, given <code>n == 6</code>, the successive values
   * of <code>n</code> would be 3, 10, 5, 16, 8, 4, 2, 1, so the method returns 8.
   * If <code>n</code> is less than 1, the method returns -1.
   * <p>
   * <em>(Remark:</em> How do we know this won't be an infinite loop for some values of
   * <code>n</code>?  In general, we don't: in fact this is a well-known open problem in 
   * mathematics.  However, it has
   * been checked for numbers up to 10 billion, which covers the range of possible values 
   * of the Java <code>int</code> type.)  
   * @param n
   *     given starting number
   * @return
   *     number of iterations required to reach <code>n == 1</code>, or
   *     -1 if <code>n</code> is not positive
   */
  public static int collatzCounter(int n)
  {
    int count = 0;
    while (n > 1) {
      if (n % 2 == 0) {
        n /= 2;
      } else {
        n = n * 3 + 1;
      }
      count++;
    }

    if (n == 1) {
      return count;
    } else {
      return -1;
    }
  }
  
  
  /**
   * Given a string consisting of a name followed by numbers, returns a 
   * string consisting of the name, followed by a colon and space,
   * followed by the average of the numbers.  For example, given the string
   * <pre>
   * "Edna von Humboldt van der Scooch 10 20 30 40", 
   * </pre>
   * returns the string
   * <pre>
   * "Edna von Humboldt van der Scooch: 25.0"
   * </pre>
   * There is always at least one token for the name and at least one number.
   * The resulting string should have exactly one space between the parts of the name,
   * and should not have any leading or trailing spaces.
   * @param text
   *   string to be parsed
   * @return
   *   name followed by colon, space, and the average of the numbers
   */
  public static String parseNameNumbers(String text)
  {
    Scanner scan = new Scanner(text);
    String name = "";
    int score = 0;
    int count = 0;

    name += scan.next();
    while (!scan.hasNextInt()) {
      name += " " + scan.next();
    }

    while (scan.hasNextInt()) {
      int token = scan.nextInt();
      score += token;
      count++;
    }

    double average = (double) score / count;

    return String.format("%s: %.1f", name, average);
  }
  
  /**
   * Returns true if string t can be obtained from string s by inserting
   * exactly two characters.  For example, given "banana" and "bannanaa", 
   * the method returns true.
   * @param s
   *   shorter string
   * @param t
   *   longer string
   * @return
   *   true if you can insert two characters into s to make it equal t
   */
  public static boolean differByTwoInsertions(String s, String t)
  {
    int count = 0;
    for (int i = 0; i < t.length(); i++) {
      if (s.length() == i - count || s.charAt(i - count) != t.charAt(i)) {
        count++;
      }
    }
    return count == 2;
  }
  
  /**
   * Given a string, returns a new string in which text between 
   * the character '+' and the next '-' is converted to uppercase.
   * Any '+' characters encountered while converting to uppercase
   * are ignored, and likewise, any '-' characters encountered
   * without a corresponding preceding '+' are also ignored.
   * If a '+' is encountered that would ordinarily not be ignored, but
   * there is no matching '-' anywhere in the rest of the string, that 
   * '+' is ignored.
   * <p>
   * For example, 
   * <ul>
   * <li> given string "aa+rdv-ark" returns "aaRDVark"
   * <li> given string "aa+r++++dv-a+---+-+r-+k" returns "aaRDVaRk"
   * </ul>
   * @param s
   *   any string
   * @return
   *   new string in which text between matching '+' and '-' characters
   *   has been converted to uppercase
   */
  public static String plusMode(String s)
  {
    String result= "";

    int x = 0;

    while (x < s.length()) {
      char xChar = s.charAt(x);
      if (xChar == '+') {
        String remaining = s.toUpperCase().substring(x, s.length());
        String upperSubstring = "";

        if (remaining.indexOf('-') != -1) {
          upperSubstring = remaining.substring(0, remaining.indexOf('-'));
        }

        for (int y = 0; y < upperSubstring.length(); y++) {
          char yChar = upperSubstring.charAt(y);
          if (yChar != '+') {
            result += yChar;
          }
          x++;
        }
      } else if (xChar != '-'){
        result += xChar;
      }
      x++;
    }

    return result;
  }
  
  /**
   * Returns a new string in which any vowel appearing by itself
   * is doubled, but groups of adjacent vowels are left alone.
   * For example, given the string "beautiful", returns "beautiifuul".
   * @param s
   *   any string
   * @return
   *   new string in which vowels are doubled, unless already part of a group
   *   of multiple vowels
   */
  public static String doubleVowelsMaybe(String s)
  {
    String temp = "";
    for (int i = 0; i < s.length(); i++) {
      char index = s.charAt(i);
      temp += index;
      if ( (i - 1 < 0 || "aeiouAEIOU".indexOf(s.charAt(i - 1)) < 0) && "aeiouAEIOU".indexOf(index) >= 0 && (i + 1 == s.length() || "aeiousAEIOU".indexOf(s.charAt(i + 1)) < 0)) {
        temp += index;
      }
    }
    return temp;
  }
  
  
  

  /**
   * Prints a pattern of n rows containing slashes, backslashes, 
   * underscores and stars, as illustrated below for n = 6.  
   * Note that the bottom row starts and ends with exactly n underscores.
   * 
   * <pre>    
   *            /\
   *           /**\
   *          /****\
   *         /******\
   *        /********\
   * ______/**********\______
   * </pre>
   * 
   * @param n
   *   number of rows in the output
   */
  public static void witchHat(int n)
  {
    if (n != 0) {
      for (int x = 0; x < n; x++) {
        for (int y = 0; y < n + (n - x - 1); y++) {
          if (x + 1 == n) {
            System.out.print("_");
          } else {
            System.out.print(" ");
          }
        }
        System.out.print('/');
        for (int y = 0; y < x * 2; y++) {
          System.out.print("*");
        }
        System.out.print('\\');
        if (x + 1 == n) {
          for (int y = 0; y < n; y++) {
            System.out.print('_');
          }
        }
        System.out.println();
      }
    } else {
      System.out.println("/\\");
    }
  }

}
