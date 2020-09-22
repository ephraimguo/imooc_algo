package self.algo.leetcode;

import java.util.TreeSet;
/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatenation, the transformation of a word.
 */

public class Leetcode_804_Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {
                ".-", // a
                "-...", // b
                "-.-.", // c
                "-..", // d
                ".", // e
                "..-.", // f
                "--.", // g
                "....", // h
                "..", // i
                ".---", // j
                "-.-", // k
                ".-..", // l
                "--", // m
                "-.", // n
                "---", // o
                ".--.", // p
                "--.-", // q
                ".-.", // r
                "...", // s
                "-", // t
                "..-", // u
                "...-", // v
                ".--", // w
                "-..-", // x
                "-.--", // y
                "--.." // z
        };

        TreeSet<String> set = new TreeSet<>();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
