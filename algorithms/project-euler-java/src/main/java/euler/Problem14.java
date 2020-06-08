package euler;

import java.util.HashMap;

public class Problem14 {
    public long first(long n) {
        long longestSequence = 0;
        long nWithLongestSequence = 0;
        long currentSize = 0;
        for(;n > 0;n--) {
            currentSize = getCollatzSequence(n);
            if(currentSize > longestSequence) {
                longestSequence = currentSize;
                nWithLongestSequence = n;
            }
        }
        return nWithLongestSequence;
    }
    public Long getCollatzSequence(long n){
        long count = 0;

        while(n != 1) {
            // Increment count
            count++;

            if (n % 2 == 0) {
                // Is even
                n = n/2;
            } else {
                // Is odd
                n = (n * 3) + 1;
            }
        }

        return count;
    }
}
