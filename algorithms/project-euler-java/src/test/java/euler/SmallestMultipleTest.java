package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmallestMultipleTest {
    SmallestMultiple l = new SmallestMultiple();

    @Test void testSmallestMultiple() {
        assertEquals(2520, l.smallestMultiple(10));
        assertEquals(232792560, l.smallestMultiple(20));
    }

    @Test void testIsDivisibleByRange() {
        assertEquals(true, l.isDivisibleByRange(2520,10));
        assertEquals(false, l.isDivisibleByRange(2, 10));
    }
}