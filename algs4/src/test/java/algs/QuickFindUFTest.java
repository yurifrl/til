package algs;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuickFindUFTest {

  @Test public void test() {
    QuickFindUF q = new QuickFindUF(10);

    // System.out.println(q.connected(0, 1));

    assertEquals(q.connected(0, 1), false);
    q.union(0, 1);
    assertEquals(q.connected(0, 1), true);
  }
}