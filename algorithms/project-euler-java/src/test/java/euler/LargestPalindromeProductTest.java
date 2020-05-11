package euler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LargestPalindromeProductTest {
    LargestPalindromeProduct l = new LargestPalindromeProduct();

    @Test void testReverse() {
        assertEquals(807, l.reverse(708));
        assertEquals(01, l.reverse(10));
    }

    @Test void testIsPalindrome() {
        assertEquals(true, l.isPalindrome(909));
        assertEquals(false, l.isPalindrome(907));
    }

    @Test void testLargestPalindromeProduct() {
        assertEquals(9009, l.largestPalindromeProduct(99, 99));
        assertEquals(906609, l.largestPalindromeProduct(999, 999));
    }
}