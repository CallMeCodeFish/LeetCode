package com.imola.leetcode.string;

/**
 * @author Heng Yu
 * @date 2/18/20 10:59 AM
 */

import java.util.Arrays;

/**
 * leetcode 186: Reverse Words in a String II
 *
 * description:
 * Given an input string , reverse the string word by word.
 *
 * example:
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Note:
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 *
 * Follow up: Could you do it in-place without allocating extra space?
 */

public class ReverseWordsII {
    //思路：先整体再局部
    public void reverseWords(char[] s) {
        //edge case
        if (s == null || s.length == 0)
            return;

        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            ++i;
            --j;
        }
        i = 0;
        j = 0;
        while (j < s.length) {
            if (j + 1 == s.length || s[j + 1] == ' ') {
                int cache = j + 1;
                while (i < j) {
                    char temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                    ++i;
                    --j;
                }
                if (cache != s.length) {
                    i = cache + 1;
                    j = cache;
                } else {
                    j = cache - 1;
                }
            }
            ++j;
        }
    }
}
