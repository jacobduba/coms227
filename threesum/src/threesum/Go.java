package threesum;

import java.util.ArrayList;
import java.util.Random;

public class Go {
    public static void main(String[] args) {
        final int N = 10;
        int[] i = stdGenerate(N);
        int[] j = stdGenerate(N);
        int[] k = stdGenerate(N);

        ArrayList<int[]> awesome = threeSum(i, j, k);
        for (int[] e : awesome) {
            for (int x = 0; x < 3; x++) {
                System.out.print(e[x] + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<int[]> threeSum(int[] i, int[] j, int[] k) {
        ArrayList<int[]> values = new ArrayList<int[]>();
        if (i.length != 1) {
            for (int index : i) {
                int[] temp = new int[1];
                temp[0] = index;
                values.addAll(threeSum(temp, j, k));
            }
        } else if (j.length != 1) {
            for (int index : j) {
                int[] temp = new int[1];
                temp[0] = index;
                values.addAll(threeSum(i, temp, k));
            }
        } else {
            for (int index : k) {
                if (i[0] + j[0] + index == 0) {
                    int[] o = {i[0], j[0], index};
                    values.add(o);
                }
            }
            values.addAll(values);
        }
        return values;
    }

    public static int[] stdGenerate(int length) {
        int[] temp = new int[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            temp[i] = rand.nextInt(2 * (int) Math.pow(10, 1)) - (int) Math.pow(10, 1);
        }

        return temp;
    }
}
