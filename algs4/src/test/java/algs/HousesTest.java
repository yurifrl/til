package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class HousesTest {
    @Test public void FirstTest() {
        Houses subject = new Houses();
        int[] arr = { 1, 0, 0, 0, 0, 1, 0, 0 };
        List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 1, 0, 1, 0));
        assertEquals(result, subject.cellCompete(arr, 1));

        int[] arr2 = { 1, 1, 1, 0, 1, 1, 1, 1};
        List<Integer> result2 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 1, 1,0));
        assertEquals(result2, subject.cellCompete(arr2, 2));
    }
}
