package algs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QuickFindUFTest {
  //
  @Test public void quickFindTest() {
    QuickFindUF q = new QuickFindUF(10);

    assertEquals(q.connected(0, 1), false);
    q.union(0, 1);
    assertEquals(q.connected(0, 1), true);
  }
}
