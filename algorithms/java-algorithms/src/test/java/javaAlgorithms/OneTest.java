package javaAlgorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneTest {
    One subject = new One();

    @Test public void firstTest() {
        String input = "Rose is a flower red rose are flower";
        List<String> excluded = new ArrayList<String>(Arrays.asList("is", "are", "a"));

        assertLinesMatch(Arrays.asList("flower", "rose"), subject.retrieveMostFrequentlyUsedWords(input, excluded));
    }

    @Test
    public void secondTest() {
        String input = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food";
        List<String> excluded = new ArrayList<String>(Arrays.asList("and", "he", "the", "to", "is"));

        assertLinesMatch(Arrays.asList("cheese", "jack", "jill", "s"), subject.retrieveMostFrequentlyUsedWords(input, excluded));
    }
}
