package javaAlgorithms;

import java.util.Collections;
import java.util.List;

public class Two {
    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        Collections.sort(logLines, (l1, l2) -> {
            System.out.println(l1);
            System.out.println(l2);
            String[] s1 = l1.split(" ", 2);
            String[] s2 = l2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                int c = s1[1].compareTo(s2[1]);
                if(c != 0) {
                    return c;
                }
                return s1[0].compareTo(s2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1): -1;
        });
        return logLines;
    }
}
