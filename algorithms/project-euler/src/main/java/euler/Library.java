/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package euler;

public class Library {
    // Find the sum of all the multiples of 3 or 5 below 1000.
    public int one(int r) {
        int acc = 0;
        for (int i = 1; i < r; i++) {
            boolean multTree = i % 3 == 0;
            boolean multFive = i % 5 == 0;
            if (multTree || multFive) {
                acc += i;
            }
        }
        return acc;
    }
    // By considering the terms in the Fibonacci sequence whose values do
    // not exceed four million, find the sum of the even-valued terms.
    public int two(int s) {
        int a = 1;
        int b = 2;
        for (int i = 0; i <= s; i ++) {
            int ob = b;
            b = a + b;
            a = ob;
        }
        return b;
    }
    // two(10)
}
