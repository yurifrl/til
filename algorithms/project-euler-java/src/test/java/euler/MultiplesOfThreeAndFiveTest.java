package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultiplesOfThreeAndFiveTest {
    MultiplesOfThreeAndFive l = new MultiplesOfThreeAndFive();

    @Test void testMultiplesOfThreeAndFive() {
        assertEquals(23, l.multiplesOfThreeAndFive(10));
        assertEquals(233168, l.multiplesOfThreeAndFive(1000));
    }
}