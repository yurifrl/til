package euler;

// 01. Find the sum of all the multiples of 3 or 5 below 1000.
public class MultiplesOfThreeAndFive {
    public int multiplesOfThreeAndFive(int r) {
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
}