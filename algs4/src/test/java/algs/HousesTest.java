package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class HousesTest {
    Houses subject = new Houses();

    @Test public void FirstTest() {
        int[] input = { 1, 0, 0, 0, 0, 1, 0, 0 };
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0));
        assertEquals(output, subject.cellCompete(input, 1));
    }

    @Test public void SecondTest() {
        int[] input = { 1, 1, 1, 0, 1, 1, 1, 1 };
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        assertEquals(output, subject.cellCompete(input, 2));
    }
}
