package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem01Test {
    Problem01 l = new Problem01();

    @Test void testExec() {
        assertEquals(23, l.exec(10));
        assertEquals(233168, l.exec(1000));
    }
}