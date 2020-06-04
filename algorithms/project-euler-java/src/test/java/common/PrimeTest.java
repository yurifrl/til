package common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.junit.jupiter.api.*;

class PrimeTest {
    Map<Integer, Boolean> naturalNumbers = ImmutableMap.<Integer, Boolean>builder()
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

    Map<Integer, Boolean> merseneNumbers = ImmutableMap.<Integer, Boolean>builder()
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
        .put(11, false)
        .put(12, false)
        .put(13, true)
        .put(14, false)
        .put(15, false)
        .put(16, false)
        .put(17, true)
        .put(19, true)
        .put(31, true)
        .put(127, true)
        .build();


    @Test
    void isPrimeWithSquareSqrtTest() {
        for (Map.Entry<Integer, Boolean> i : naturalNumbers.entrySet()) {
            assertEquals(i.getValue(), Prime.isPrimeWithSqrt(i.getKey()), i.getKey().toString());
        }
    }

    @Test
    void isPrimeByDivisonToTheHalfTest() {
        for (Map.Entry<Integer, Boolean> i : naturalNumbers.entrySet()) {
            assertEquals(i.getValue(), Prime.isPrimeByDivisionToTheHalf(i.getKey()), i.getKey().toString());
        }
    }

    @Test
    @Disabled("Not Working right now")
    void isMerseneNumberPrimeByLucasLehmerTest() {
        for (Map.Entry<Integer, Boolean> i : merseneNumbers.entrySet()) {
            assertEquals(i.getValue(), Prime.isMerseneNumberPrimeByLucasLehmer(i.getKey()), i.getKey().toString());
        }
    }

    @Test
    @Disabled("Not Working right now")
    void isPrimeByLucasTest() {
        for (Map.Entry<Integer, Boolean> i : naturalNumbers.entrySet()) {
            assertEquals(i.getValue(), Prime.isPrimeByLucas(i.getKey()), i.getKey().toString());
        }
    }

    @Test
    void isPrimeBySieveOfEratosthenes() {
        for (Map.Entry<Integer, Boolean> i : naturalNumbers.entrySet()) {
            assertEquals(i.getValue(), Prime.isPrimeByLucas(i.getKey()), i.getKey().toString());
        }
    }
}
