package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library l = new Library();

    @Test void testOne() {
        assertEquals(23, l.one(10), "should be 23");
        assertEquals(233168, l.one(1000));
    }


    @Test void testSomeLibraryMethod() {
        // 1, 2, 3, 5, 8 == 10
        // assertEquals(10, l.two(8, 1, 2, 0));
        // 1, 2, 3, 5 == 11
        // assertEquals(11, l.two(5, 1, 2, 0));
        // 1, 2, 3 == 6
        assertEquals(6, l.two(3));

    }
}
