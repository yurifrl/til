package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.Test;

class PrimeTest {
    Map<Integer, Boolean> inputs = ImmutableMap.<Integer, Boolean>builder()
        .put(1, false)
        .put(2, true)
        .put(3, true)
        .put(4, false)
        .put(5, true)
        .put(6, false)
        .put(7, true)
        .put(8, false)
        .put(9, false)
        .put(10, false)
        .build();

    // @Test
    // void isPrimeWithSquareSqrtTest() {
    //     for (Map.Entry<Integer, Boolean> i : inputs.entrySet()) {
    //         assertEquals(i.getValue(), Prime.isPrimeByLucasLehmer(i.getKey()), i.getKey().toString());
    //     }
    // }

    // @Test
    // void isPrimeByDivisonToTheHalfTest() {
    //     for (Map.Entry<Integer, Boolean> i : inputs.entrySet()) {
    //         assertEquals(i.getValue(), Prime.isPrimeByLucasLehmer(i.getKey()), i.getKey().toString());
    //     }
    // }

    @Test
    void isPrimeByLucasLehmerTest() {
        for (Map.Entry<Integer, Boolean> i : inputs.entrySet()) {
            assertEquals(i.getValue(), Prime.isPrimeByLucasLehmer(i.getKey()), i.getKey().toString());
        }
    }

    @Test
    void testLucasLehmerSequenceTest() {
        assertEquals(4, Prime.getLucasLehmerNumberAtPoint(0));
        assertEquals(14, Prime.getLucasLehmerNumberAtPoint(1));
        assertEquals(194, Prime.getLucasLehmerNumberAtPoint(2));
        assertEquals(37634, Prime.getLucasLehmerNumberAtPoint(3));
        assertEquals(1416317954, Prime.getLucasLehmerNumberAtPoint(4));
    }
}
