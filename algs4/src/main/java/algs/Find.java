package algs;

import edu.princeton.cs.algs4.UF;
import utils.Reader;

public class Find {
    public String find(Reader r) {
        int n = r.readInt();
        UF uf = new UF(n);
        String buffer = "";
        while (!r.isEmpty()) {
            int p = r.readInt();
            int q = r.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                buffer += p + " " + q;
            }
        }
        return buffer;
    }
}
