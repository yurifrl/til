package ctci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Chapter01ArraysAndStringsTest {
    Chapter01ArraysAndStrings subject = new Chapter01ArraysAndStrings();

    @Test
    void oneTest() {
        assertEquals(true, subject.one("abc".toCharArray()));
        assertEquals(false, subject.one("abcc".toCharArray()));
    }

    @Test
    void twoTest() {
        assertEquals(true, subject.two("murder".toCharArray(),
                                       "redrum".toCharArray()),
                     "murder and redrum");

        assertEquals(true, subject.two("murder".toCharArray(),
                                       "REDRUM".toCharArray()),
                     "murder and REDRUM");

        assertEquals(false, subject.two("restroom".toCharArray(),
                                       "redrum".toCharArray()),
                     "restroom and redrum");
    }

    @Test
    void threeTest() {
        assertEquals("Mr%20John%20Smith", subject.three("Mr John Smith    ", 13), "Mr John Smith");
    }

    @Test
    void fourTest() {
        assertEquals(true, subject.four("Tact Coa"), "Tact Coa");
    }
}
