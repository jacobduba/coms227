import java.util.Scanner;

class CPC100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int inputX = scan.nextInt();
            int inputY = scan.nextInt();

            int x = inputX;
            int y = inputY;

            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }

            int max = -1;
            for (int i = x; i <= y; i++) {
                int num = collatzCounter(i);
                if (num > max) {
                    max = num;
                }
            }
            System.out.println(inputX + " " + inputY + " " + max);
        }
    }

    public static int collatzCounter(int n) {
        int count = 1;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            count++;
        }

        return count;
    }
}
