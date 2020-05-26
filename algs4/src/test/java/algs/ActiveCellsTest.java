package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ActiveCellsTest {
    ActiveCells subject = new ActiveCells();

    @Test public void CompeteTest() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0, 1, 0, 0 ));
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0));
        assertIterableEquals(output, subject.compete(input, input.size()));
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
