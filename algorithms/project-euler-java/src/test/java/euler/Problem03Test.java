package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem03Test {
    Problem03 l = new Problem03();

    @Test void testExec() {
        assertEquals(5, l.exec(90));
        assertEquals(29, l.exec(13195));
        assertEquals(6857, l.exec(new Long("600851475143")));
    }
}