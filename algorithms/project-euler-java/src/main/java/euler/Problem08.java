package euler;

import java.util.LinkedList;

public class Problem08 {
    // Find the thirteen adjacent digits in the 1000-digit number
    // that have the greatest product.What is the value of this product?
    public long exec(int[] n, int count) {
        // Create a array for the candidates
        //   Loaded with the first fourt elements of the array
        // Create a win variable
        // with the sum of the four first elements
        // Sum first four
        // Loop through the array
        long pointerProduct = 1,
             winnerProduct = 1,
             last = 0;
        LinkedList<Long> pointer = new LinkedList<Long>();
        for (long i : n) {
            // If index is 0
            if (i == 0) {
                pointer.clear();
                pointerProduct = 1;
                continue;
            }
            pointer.addLast(i);
            pointerProduct = pointerProduct * i;
            if (pointer.size() <= count) {
                continue;
            }
            // Move pointer, removing last
            last = pointer.pop();
            // And always remove last from product
            pointerProduct = pointerProduct / last;

            if (pointerProduct > winnerProduct) {
                winnerProduct = pointerProduct;
            }
        }
        return winnerProduct;
    }
}
