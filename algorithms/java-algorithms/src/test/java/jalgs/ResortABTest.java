package javaAlgorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResortABTest {
    ResortAB subject = new ResortAB();

    @Test public void firstTest() {
        assertEquals(1, subject.resortAB());
    }
}
