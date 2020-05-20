package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem02Test {
    Problem02 l = new Problem02();

    @Test void testExec() {
        // 0, 1, 1, 2, 5, 8
        assertEquals(10, l.exec(10));
        //
        assertEquals(4613732, l.exec(4000000));
    }
}