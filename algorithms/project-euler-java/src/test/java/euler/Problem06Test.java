package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem06Test {
    Problem06 l = new Problem06();

    @Test void testExec() {
        assertEquals(2640, l.exec(10));
        assertEquals(25164150, l.exec(100));
    }
}
