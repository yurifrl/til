package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GCDTest {
    @Test public void FirstTest() {
        GCD subject = new GCD();
        int[] arr = { 2, 3, 4, 5, 6 };
        assertEquals(1, subject.generalizedGCD(5 , arr));

        int[] arr2 = { 2, 4, 6, 8, 10 };
        assertEquals(2, subject.generalizedGCD(5, arr2));
    }
}
