package mini2;

import java.util.ArrayList;

public class ArrayOfSunshine
{
  
  // disable instantiation
  private ArrayOfSunshine() {}
  
  /**
   * Returns the longest string that is a prefix of
   * all strings in the given array.  For example, 
   * if the array is ["foo", "four", "football"], the
   * method returns "fo".  If the array is empty, returns
   * an empty string.
   * @param arr
   *   any array of strings.
   * @return
   *   longest common prefix of the given strings
   */
  public static String longestCommonPrefix(String[] arr)
  {
    if (arr.length == 0) {
      return "";
    }

    int shortest = Integer.MAX_VALUE;
    for (int x = 0; x < arr.length; x++) {
      int length = arr[x].length();
      if (length < shortest) {
        shortest = length;
      }
    }

    String epic = "";
    for (int x = 0; x < shortest; x++) {
      char current = arr[0].charAt(x);
      for (int y = 0; y < arr.length; y++) {
        if (current != arr[y].charAt(x)) {
          return epic;
        }
      }
      epic += current;
    }
    return epic;
  }
  
  /**
   * Modifies the given array by exchanging the first half
   * with the second half.  If the array has odd length, the
   * center element is not moved.  For example, given array
   * <pre>
   * [2, 4, 6, 99, 1, 2, 3]
   * </pre>
   * after swapFirstLast the array
   * contains
   * <pre>
   * [1, 2, 3, 99, 2, 4, 6]
   * </pre>
   * Note this method modifies the given array and returns
   * void.
   * @param arr
   *   the int array to be modified
   */
  public static void swapFirstLast(int[] arr)
  {
    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[(arr.length + 1) / 2 + i];
      arr[(arr.length + 1) / 2 + i] = temp;
    }
  }
  
  /**
   * Rearrange the elements of arr according to the given list of
   * indices.  After calling this method, arr[i] should be
   * the value formerly located at arr[swizzler[i]].
   * For example, if swizzler is [3, 0, 3, 1] and arr is 
   * <pre>
   * [10, 20, 30, 40]
   * </pre>
   * and
   * then after this method executes, arr is
   * <pre>
   * [40, 10, 40, 20].
   * </pre>  
   * If the swizzler length
   * does not match the array length, or if it contains any
   * number that is out of range as an index in arr, 
   * the method does nothing.  Note that this method 
   * modifies the given array and returns void.
   * @param arr
   *   the int array to be modified
   * @param swizzler
   *   array of indices indicating new positions of elements
   */
  public static void swizzle(int[] arr, int[] swizzler)
  {
    boolean good = true;
    for (int i = 0; i < swizzler.length; i++) {
      if (0 > swizzler[i] || arr.length - 1 < swizzler[i]) {
        good = false;
      }
    }
    if (arr.length == swizzler.length && good) {
      int[] newArr = new int[arr.length];
      for (int i = 0; i < swizzler.length; i++) {
        newArr[i] = arr[swizzler[i]];
      }

      for (int i = 0; i < arr.length; i++) {
        arr[i] = newArr[i];
      }
    }
  }
  
  /**
   * Creates a new array from the given one by adding up groups
   * of k adjacent entries.  The length of the returned array
   * is always <code>arr.length / k</code> (integer division), 
   * and its ith element is the sum
   * <p>
   * arr[ik] + arr[ik + 1] + arr[ik + 2] + ... + arr[ik + (k - 1)]
   * <p>
   * If the array length is not an exact multiple
   * of k, the excess elements are ignored.  For example, if
   * arr is [1, 2, 3, 4, 5, 6, 7] and k is 3, the 
   * result is [6, 15].
   * @param arr
   *   any int array
   * @param k
   *   number of adjacent elements in each group
   * @return
   *   new array obtained by adding up groups of adjacent elements
   */
  public static int[] condense(int[] arr, int k)
  {
    int[] temp = new int[arr.length / k];
    for (int x = 0; x < temp.length; x++) {
      for (int y = 0; y < k; y++) {
        temp[x] += arr[y + x * k];
      }
    }
    return temp;
  }
  
  /**
   * Determines whether arr is a permutation.  We define
   * a permutation as an array in which each number 
   * 0 through n - 1 appears exactly once, where n is 
   * the length of the array.
   * @param arr
   *   an int array
   * @return
   *   true if the given array is a permutation, false otherwise
   */
  public static boolean isPermutation(int arr[])
  {
    for (int x = 0; x < arr.length; x++) {
      boolean hasPermThere = false;
      for (int y = 0; y < arr.length; y++) {
        if (arr[y] == x) {
          hasPermThere = true;
        }
      }
      if (!hasPermThere) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Returns the cycle in arr beginning with the given starting index.
   * A <em>cycle</em> in an array is a sequence of indices 
   * i<sub>0</sub>, i<sub>1</sub>, i<sub>2</sub>, ...i<sub>k</sub>
   * for some k &gt;= 0, such that:
   * <p>
   * i<sub>1</sub> = arr[i<sub>0</sub>], i<sub>2</sub> = arr[i<sub>1</sub>], 
   * ..., and i<sub>0</sub> = arr[i<sub>k</sub>].  
   * <p>The sequence
   * of indices is returned as an int array with the given start index
   * at position 0.  
   * For example, given [2, 4, 0, 1, 3] and start = 3, the method
   * returns [3, 1, 4].  (Note that if arr[start] == start, then
   * the resulting cycle has length 1.)
   * Returns null if the given array is not
   * a permutation, or if the start index is out of bounds in arr.
   * @param arr
   *   an int array
   * @param start
   *   starting point for finding a cycle
   * @return
   *   array containing cycle indices, beginning with given start index
   *   
   */
  public static int[] findOneCycle(int[] arr, int start)
  {
    if (!isPermutation(arr) || start < 0 || start > arr.length - 1) {
      return null;
    }

    int count = 1;
    int num = start;
    while (arr[num] != start) {
      num = arr[num];
      count++;
    }

    int temp[] = new int[count];
    num = start;
    temp[0] = start;
    for (int i = 1; i < count; i++) {
      temp[i] = arr[num];
      num = temp[i];
    }
    return temp;
  }
  
  /**
   * Returns a list of all cycles in the given array.
   * For example, given [2, 1, 3, 0, 5, 4], the resulting
   * list should contain [0, 2, 3], [1], and [4, 5].
   * The cycles in the resulting list should be disjoint; that is,
   * for example, 
   * the list should not contain [2, 3, 0] in addition to
   * [0, 2, 3], even though both arrays describe the same cycle.
   * The order of cycles in the list is not specified.
   * Returns an empty list if arr is not a permutation.
   * @param arr
   *   an int array
   * @return
   *   list of all cycles
   */
  public static ArrayList<int[]> findAllCycles(int[] arr)
  {
    ArrayList<int[]> temp = new ArrayList<int[]>();
    ArrayList<Integer> used = new ArrayList<Integer>();

    if (!isPermutation(arr)) {
      return temp;
    }

    for (int x = 0; x < arr.length; x++) {
      if (!used.contains(x)) {
        int count = 1;
        int num = x;
        while (arr[num] != x) {
          num = arr[num];
          count++;
        }

        int temp2[] = new int[count];
        num = x;
        temp2[0] = x;
        for (int i = 1; i < count; i++) {
          temp2[i] = arr[num];
          used.add(arr[num]);
          num = temp2[i];
        }
        temp.add(temp2);
      }
    }

    return temp;
  }
}
