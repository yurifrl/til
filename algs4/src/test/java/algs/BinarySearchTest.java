package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    @Test public void binarySearch() {
        int[] haystack = { 1, 71, 3, 4, 5, 6, 7 };
        assertEquals(0, BinarySearch.binarySearch(1, haystack));
        assertEquals(6, BinarySearch.binarySearch(71, haystack));
    }
}
