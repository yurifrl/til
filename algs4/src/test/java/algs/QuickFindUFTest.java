package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickFindUFTest {
  //
  @Test public void quickFindTest() {
    QuickFindUF q = new QuickFindUF(10);

    assertEquals(q.connected(0, 1), false);
    q.union(0, 1);
    assertEquals(q.connected(0, 1), true);
  }
}
