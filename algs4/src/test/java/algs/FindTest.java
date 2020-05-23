package algs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FindTest {
    @Test public void secondTest() {
      Find classUnderTest = new Find();
      int[] id = {0,1,2,3,4,5,6,7,8,9};
      assertNotNull("hy", classUnderTest.find());
    }
}

