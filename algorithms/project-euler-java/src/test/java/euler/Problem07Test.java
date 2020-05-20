package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem07Test {
    Problem07 l = new Problem07();

    @Test void testExec() {
        assertEquals(13, l.exec(6));
        assertEquals(104743, l.exec(10001));
    }

    @Test void testIsPrime() {
        assertEquals(true, l.isPrime(2));
        assertEquals(true, l.isPrime(3));
        assertEquals(true, l.isPrime(5));
        assertEquals(true, l.isPrime(7));
        assertEquals(true, l.isPrime(11));
        assertEquals(true, l.isPrime(13));
    }
}
