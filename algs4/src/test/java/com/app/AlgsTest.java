package test.java.com.app;

import main.java.com.app.Algs;
//import junit.framework.Test;
import junit.framework.TestCase;
//import junit.framework.TestSuite;

// C-a + s to run tests in the next split pane with tmux
public class AlgsTest extends TestCase {
  public void testSqrt() {
    assertEquals(Algs.sqrt(4), 2.0);
  }

  public void testAverage() {
    assertEquals(Algs.testAverage(), 0.0);
  }

  public void testBinarySearch() {
    int[] haystack = { 1, 71, 3, 4, 5, 6, 7 };
    assertEquals(0, Algs.binarySearch(1, haystack));
    assertEquals(6, Algs.binarySearch(71, haystack));
  }
}
