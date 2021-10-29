package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumber2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("../project5/src/lab5/SimpleLoops.java");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.length());

        Scanner scanner = new Scanner(file);
        int lineCount = 1;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.print(lineCount + " ");
            System.out.println(line);
            lineCount += 1;
        }
        scanner.close();

        File story = new File("story.txt");
        printNumOfWords(file);
    }

    public static void printNumOfWords(File file) throws FileNotFoundException {
        Scanner scanLine = new Scanner(file);
        Scanner scanWords;

        while (scanLine.hasNextLine()) {
            String line = scanLine.nextLine();

            scanWords = new Scanner(line);
            int count = 0;
            while (scanWords.hasNext()) {
                count++;
                scanWords.next();
            }
            System.out.println(count);
        }
    }
}
