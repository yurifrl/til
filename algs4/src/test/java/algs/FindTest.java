package algs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import utils.TinyUF;

public class FindTest {
    public Find subject = new Find();

    @Test
    public void secondTest() throws Exception {
        TinyUF res = new TinyUF();
        assertEquals("4 33 86 59 42 15 07 26 1", subject.find(res));
    }
}
