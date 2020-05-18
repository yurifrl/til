package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumSquareDifferenceTest {
    SumSquareDifference l = new SumSquareDifference();

    @Test void testSumSquareDifference() {
        assertEquals(2640, l.sumSquareDifference(10));
    }
}
