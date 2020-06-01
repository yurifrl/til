package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem03Test {
    Problem03 l = new Problem03();

    @Test void firstExec() {
        assertEquals(5, l.first(90));
        assertEquals(29, l.first(13195));
        assertEquals(6857, l.first(Long.valueOf("600851475143")));
    }

    @Test
    void secondExec() {
        assertEquals(5, l.second(90));
        assertEquals(29, l.second(13195));
        assertEquals(6857, l.second(Long.valueOf("600851475143")));
    }
}
