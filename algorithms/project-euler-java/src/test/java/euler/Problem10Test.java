package euler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem10Test {
    Problem10 subject = new Problem10();

    @Test
    void firstTest() {
        assertEquals(17, subject.first(10));
    }

    @Test
    void firstLongTest() {
        assertEquals(Long.valueOf("142913828922"), subject.first(Long.valueOf("2000000")));
    }

    @Test
    void secondTest() {
        assertEquals(17, subject.second(10));
    }

    @Test
    void secondLogTest() {
        assertEquals(Long.valueOf("142913828922"), subject.second(Long.valueOf("2000000")));
    }
}
