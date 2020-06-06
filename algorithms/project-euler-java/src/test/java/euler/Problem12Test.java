package euler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem12Test {
    Problem12 subject = new Problem12();

    @Test
    void firstTest() {
        assertEquals(28, subject.first(5));
    }

    // @Test
    // void longTest() {
    //     assertEquals(28, subject.first(10));
    // }
}
