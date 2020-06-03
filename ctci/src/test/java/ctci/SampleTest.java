package ctci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SampleTest {
    Sample subject = new Sample();

    @Test
    void firstTest() {
        assertEquals(1, subject.one());
    }
}
