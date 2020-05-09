package main.java.com.app;

import edu.princeton.cs.algs4.Average;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;
import java.lang.Math;

public class Algs {
  public static double sqrt(double c) {
    if (c < 0)
      return Double.NaN;

    double err = 1e-15;
    double t = c;

    while (Math.abs(t - c / t) > err * t)
      t = (c / t + t) / 2.0;

    return t;
  }

  public static double testAverage() {
    Average.main(new String[] {});

    return 0.0;
  }

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
