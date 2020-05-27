package algs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import utils.TinyUF;

public class FindTest {
    public Find subject = new Find();

    @Test
    public void secondTest() throws Exception {
        TinyUF res = new TinyUF();
        assertEquals("hy", subject.find(res));
    }
}
