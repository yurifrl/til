package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LargestPrimeFactorTest {
    LargestPrimeFactor l = new LargestPrimeFactor();

    @Test void testLargestPrimeFactor() {
        assertEquals(5, l.largestPrimeFactor(90));
        assertEquals(29, l.largestPrimeFactor(13195));
        assertEquals(6857, l.largestPrimeFactor(new Long("600851475143")));
    }
}