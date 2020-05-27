package algs;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] arr) {
      int lower = 0;
      int higher = arr.length - 1;
      while (lower <= higher) {
        int mid = lower + (higher - lower) / 2;

        if (key < arr[mid])
          higher = mid - 1;
        else if (key > arr[mid])
          lower = mid + 1;
        else
          return mid;
      }
      return -1;
    }

    public static int binarySearch(int needle, int[] haystack) {
      Arrays.sort(haystack);
      return rank(needle, haystack);
    }
}
