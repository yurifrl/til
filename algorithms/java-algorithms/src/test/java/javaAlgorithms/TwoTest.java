package javaAlgorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoTest {
    Two subject = new Two();

    @Test public void firstTest() {
        List<String> input = new ArrayList<String>(Arrays.asList("mi2 jog mid pet", "wz3 34 54 398", "a1 alps cow bar" , "x4 45 21 7"));
        System.out.println(subject.reorderLines(4, input));
    }

    @Test
    public void secondTest() {
        List<String> input = new ArrayList<String>(
                                                   Arrays.asList("t2 13 121 98", "r1 box ape bit", "b4 xi me nu", "br8 eat nim did", "w1 has uni gry", "f3 53 53 31"));
        System.out.println(subject.reorderLines(6, input));
    }
}
