package javaAlgorithms;

import java.util.ArrayList;
import java.util.List;

// References
//
// https://stackoverflow.com/questions/29910312/algorithm-to-get-all-the-combinations-of-size-n-from-an-array-java
// https://www.hackerrank.com/challenges/array-pairs/problem
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
    public long arrayPairs(int n, int[] input) {
        return 1;
    }

    public List<int[]> combine(int k, int[] input) {
        List<int[]> subsets = new ArrayList<>();
        // indexes array pointing to the input array
        int[] s = new int[k];

        // Initialize s array
        for (int i = 0; (s[i] = i) < k - 1; i++);
        subsets.add(getSubset(input, s));

        while(true) {
            int i;
            // find position of item that can be incremented
            for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--);
            if (i < 0) {
                break;
            }
            s[i]++;                    // increment this item
            for (++i; i < k; i++) {    // fill up remaining items
                s[i] = s[i - 1] + 1;
            }
            subsets.add(getSubset(input, s));
        }

        // System.out.println(Arrays.deepToString(subsets.toArray()));
        return subsets;
    };

    // generate actual subset by index sequence
    public int[] getSubset(int[] input, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++) {
            result[i] = input[subset[i]];
        }
        return result;
    }
}
