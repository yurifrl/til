package ctci;

import java.util.*;

// Exercices start at page 90
// The Chapter start at page 88
public class Chapter01ArraysAndStrings {
    // 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
    // Hints: #44, # 777, # 7 32
    public boolean one(char[] chars) {
        Hashtable<Character, Boolean> t = new Hashtable<>();
        for(char c : chars) {
            if(t.containsKey(c)) {
                return false;
            }
            t.put(c, true);
        }
        return true;
    }

    // 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
    // Hints: #7, #84, #722, #737
    public boolean two(char[] a, char[] b){
        for (int i = 0; i < a.length; i ++) {
            a[i] = Character.toLowerCase(a[i]);
        }
        for (int i = 0; i < b.length; i ++) {
            b[i] = Character.toLowerCase(b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    // 1.3 URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
    // EXAMPLE
    //     Input: "Mr John Smith    ", 13
    //     Output: "Mr%20John%20Smith"
    //
    // Hints: #53, #7 78
    public String three(String s, int l) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < l; i++) {
            char[] buffer = chars.clone();
            if (chars[i] != ' ') {
                continue;
            }
            // this index is a space
            // now use buffer to recostruct string
            for(int j = i; j <= l; j++) {
                chars[j+3] = buffer[j+1];
            }
            // move add the expecial char
            chars[i] = '%';
            chars[i+1] = '2';
            chars[i+2] = '0';
            // move the index to ignore the mode characters
            i += 2;
        }

        String str = new String(chars);
        return str;
    }


    // 1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    //     EXAMPLE
    //     Input: Tact Coa
    //     Output: True (permutations: "taco cat". "atco cta". etc.)
    //
    // Hints: #106, #121, #134, #136
    public boolean four(String s) {
        return false;
    }

    // 1.5 One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
    // EXAMPLE
    // pale,  ple -> true
    // pales, pale -> true
    // pale,  bale -> true
    // pale,  bake -> false
    // Hints: #23, #97, #130

    // 1.6 String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    // Hints: #92, # 11 0

    // 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
    // Hints: #51, #100

    // 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to O.
    // Hints: # 17, #74, #102

    // 1.9 String Rotation: Assume you have a method isSubst ring which checks if one word is a substring of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
    // Hints: #34, #88, #104
}
// Additional Questions: Object-Oriented Design (#7.12), Recursion (#8.3), Sorting and Searching (#10.9), C++ (#12.11), Moderate Problems (#16.8, #16.17, #16.22), Hard Problems (#17.4, #17.7, #17.13, #17.22, #17.26).
// Hints start on page 653.
