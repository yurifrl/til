package euler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem09Test {
    Problem09 subject = new Problem09();

    @Test
    void testExec() {
        assertEquals(31875000, subject.exec(1000));
    }
}
