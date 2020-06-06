package common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

class LoopVisualizerTest {
    LoopVisualizer subject = new LoopVisualizer();
    String output = "";

    @Test
    void visualizeTest() {
        subject.navigate();
        // assertEquals(output, subject.visualize());
    }
}
