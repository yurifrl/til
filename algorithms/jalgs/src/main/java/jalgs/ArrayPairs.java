package jalgs;

import java.util.ArrayList;
import java.util.List;

class ArrayPairs {
    // Consider an array of n integers A = [a1, a2, ... , an]
    // Find and print the total number of (i,j) pairs such that
    // ai x aj < max(ai,ai + 1, ..., aj) where i < j
    //
    // input: 1 1 2 4 2
    // output: 8
    //
    // There are eight pairs of indices satisfying the given criteria:
    // (1,2), (1,3), (1,4), (1,5), (2,3), (2,4), (2,5) and (3,5).
    // Thus, we print  as our answer.
    static long arrayPairs(int n, int[] arr) {
        List<int[]> list = new ArrayList<int[]>();

        // Loop throug all pairs combination
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] b = new int[]{arr[i], arr[j]};
                System.out.println(b);
            }
        }
        return 1;
    }
}
