package com.imola.leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/18/20 11:14 AM
 */

/**
 * example:
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 */

class ReverseWordsIITest {
    public static void main(String[] args) {
        ReverseWordsII solution = new ReverseWordsII();
        char[] s = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        solution.reverseWords(s);
    }
}