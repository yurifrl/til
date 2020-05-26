package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class HousesTest {
    Houses subject = new Houses();

    @Test public void CompeteTest() {
        int[] input = { 1, 0, 0, 0, 0, 1, 0, 0 };
        int[] output = { 0, 1, 0, 0, 1, 0, 1, 0 };
        assertArrayEquals(output, subject.compete(input, input.length));
    }

    @Test public void FirstTest() {
        int[] input = { 1, 0, 0, 0, 0, 1, 0, 0};
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0));
        assertIterableEquals(output, subject.cellCompete(input, 1));
    }

    @Test public void SecondTest() {
        int[] input = { 1, 1, 1, 0, 1, 1, 1, 1 };
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        assertIterableEquals(output, subject.cellCompete(input, 2));
    }
}
