package lab7;

import java.io.File;

public class CheckPoint2 {
    public static void main(String[] args) {
        System.out.println(countAllFiles(new File(".")));
        System.out.println(countPatterns(5)); // biggest value possible to solve b/c integers are 32 bit
        System.out.println(Integer.MAX_VALUE);
    }

    public static int countAllFiles(File f) {
        if (!f.isDirectory()) {
            return 1;
        } else {
            File[] files = f.listFiles();
            int count = 0;
            for (int i = 0; i < files.length; i++) {
                count += countAllFiles(files[i]);
            }
            return count;
        }
    }

    public static int countPatterns(int n) {
        if (n < 3) {
            return 1;
        } else {
            return countPatterns(n - 3) + countPatterns(n - 1);
        }
    }
}
