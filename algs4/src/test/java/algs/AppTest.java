package algs;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void sqrt() {
        assertEquals(2.0, 2.0, 0);
    }

    @Test public void average() {
        assertEquals(App.testAverage(), 0.0, 0);
    }

    @Test public void binarySearch() {
        int[] haystack = { 1, 71, 3, 4, 5, 6, 7 };
        assertEquals(0, App.binarySearch(1, haystack));
        assertEquals(6, App.binarySearch(71, haystack));
    }
}
