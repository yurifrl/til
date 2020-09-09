package javaAlgorithms;

import java.util.*;

public class One {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> retrieveMostFrequentlyUsedWords(String helpText, List<String> wordsToExclude) {
        // WRITE YOUR CODE HERE
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        String delimiters = " |'|\\.";
        Integer threshold = 2;
        String[] wordList = helpText.toLowerCase().split(delimiters);
        Integer count;
        String word;
        // First we populate a more eficient data structure for counting
        for (int i = 0; i < wordList.length; i ++) {
            word = wordList[i];
            // If key exists we sum one
            if(m.containsKey(word)) {
                count = m.get(word);
                m.put(word, count + 1);
                continue;
            }
            // If not just initialize
            m.put(word, 1);
        }
        for(Map.Entry<String, Integer> entry : m.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            Boolean isNotExluded = !wordsToExclude.contains(key);
            if (value >= threshold && isNotExluded) {
                list.add(key);
            }
        }

        // now in a single loop, we will remove the excluded terms
        // We could do it in the previous loop but It might be more eficient
        // to make this search here

        return list;
    }
}
