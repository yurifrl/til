package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem05Test {
    Problem05 l = new Problem05();

    @Test void testExec() {
        assertEquals(2520, l.exec(10));
        assertEquals(232792560, l.exec(20));
    }

    @Test void testIsDivisibleByRange() {
        assertEquals(true, l.isDivisibleByRange(2520,10));
        assertEquals(false, l.isDivisibleByRange(2, 10));
    }
}