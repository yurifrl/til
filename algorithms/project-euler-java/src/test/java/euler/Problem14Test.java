package euler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem14Test {
    Problem14 subject = new Problem14();

    @Test
    void secondTest() {
        assertEquals(837799, subject.first(1000000));
    }
}
