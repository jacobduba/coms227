package lab7;

public class CheckPoint1
{
    public static void main(String[] args)
    {
        int[] test = {3, 4, 5, 1, 2, 3, 2}; // max should be 5
        int result = maxValue(test);
        System.out.println(result);
        System.out.println(getPyramidCount(5));
    }

    public static int maxValue(int[] array) {
        return maxValue(array, 0, array.length - 1);
    }

    public static int maxValue(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        } else {
            int mid = (start + end) / 2;
            int leftMax = maxValue(array, start, mid);
            int rightMax = maxValue(array, mid + 1, end);
            return Math.max(leftMax, rightMax);
        }
    }

    public static int getPyramidCount(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * n + getPyramidCount(n - 1);
        }
    }
}
