package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/3/20 5:47 PM
 */

/**
 * leetcode 394: Decode String
 *
 * description:
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * example:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class DecodeString {
    public String decodeString(String s) {
        //edge case

        return dfs(1, s);
    }

    private String dfs(int k, String s) { // k = 1, s = "3[a]2[bc]", s.length = 9 |  k = 3, s = "a" | 2 "bc"
        //edge case

        //split and parse s and then dfs
        int digitStart = -1;
        int leftBracket = -1;
        int rightBracket = -1;
        int count = 0;
        int cur = 0;
        StringBuilder builder = new StringBuilder();
        while (cur < s.length()) { //"3[a]2[bc]"  ,   cur = 8
            char c = s.charAt(cur); //b
            if ('[' == c) {
                ++count; //1
                if (leftBracket == -1) {
                    leftBracket = cur; //5
                }
            } else if (']' == c) {
                --count; //0
                if (count == 0) {
                    rightBracket = cur; //8
                    int nextK = Integer.parseInt(s.substring(digitStart, leftBracket)); // 2
                    builder.append(dfs(nextK, s.substring(leftBracket + 1, rightBracket)));
                    leftBracket = -1;
                    rightBracket = -1;
                    digitStart = -1;
                }
            } else if (Character.isDigit(c) && digitStart == -1) {
                digitStart = cur; //4
            } else if (Character.isLetter(c)) { //letter
                if (count == 0) {
                    builder.append(c);
                }
            }
            ++cur;
        }
        int length = builder.length();
        for (int i = 0; i < k - 1; ++i) {
            builder.append(builder.substring(0, length));
        }
        return builder.toString();
    }
}
