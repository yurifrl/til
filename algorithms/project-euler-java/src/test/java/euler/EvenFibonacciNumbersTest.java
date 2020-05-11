package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvenFibonacciNumbersTest {
    EvenFibonacciNumbers l = new EvenFibonacciNumbers();

    @Test void testEvenFibonacciNumbers() {
        // 0, 1, 1, 2, 5, 8
        assertEquals(10, l.evenFibonacciNumbers(10));
        //
        assertEquals(4613732, l.evenFibonacciNumbers(4000000));
    }
}