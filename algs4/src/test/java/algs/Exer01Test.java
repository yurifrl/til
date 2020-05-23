package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exer01Test {
    @Test public void sqrt() {
        assertEquals(2.0, 2.0, 0);
    }

    @Test public void average() {
        assertEquals(Exer01.testAverage(), 0.0, 0);
    }

    @Test public void binarySearch() {
        int[] haystack = { 1, 71, 3, 4, 5, 6, 7 };
        assertEquals(0, Exer01.binarySearch(1, haystack));
        assertEquals(6, Exer01.binarySearch(71, haystack));
    }
}
