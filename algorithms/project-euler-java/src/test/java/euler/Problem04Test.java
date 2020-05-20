package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem04Test {
    Problem04 l = new Problem04();

    @Test void testExec() {
        assertEquals(9009, l.exec(99, 99));
        assertEquals(906609, l.exec(999, 999));
    }

    @Test void testReverse() {
        assertEquals(807, l.reverse(708));
        assertEquals(01, l.reverse(10));
    }

    @Test void testIsPalindrome() {
        assertEquals(true, l.isPalindrome(909));
        assertEquals(false, l.isPalindrome(907));
    }
}