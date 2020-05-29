package jalgs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayPairsTest {
    ArrayPairs subject = new ArrayPairs();

    @Test public void firstTest() {
        int[] input = {1, 1, 2, 4, 2};
        assertEquals(5, subject.arrayPairs(input.length, input));
    }
}
