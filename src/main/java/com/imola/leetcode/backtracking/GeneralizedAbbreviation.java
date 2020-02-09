package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/8/20 7:15 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 320: Generalized Abbreviation
 * <p>
 * description:
 * Write a function to generate the generalized abbreviations of a word.
 * <p>
 * Note: The order of the output does not matter.
 * <p>
 * example:
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        //edge case
        if (word == null)
            return res;
        if (word.length() == 0) {
            res.add("");
            return res;
        }

        StringBuilder builder = new StringBuilder();
        backtrack(word, 0, res, builder);
        return res;
    }

    private void backtrack(String word, int i, List<String> res, StringBuilder builder) {
        //edge case
        if (i == word.length()) {
            res.add(builder.toString());
            return;
        }

        //add char
        builder.append(word.charAt(i));
        backtrack(word, i + 1, res, builder);
        builder.deleteCharAt(builder.length() - 1);
        //add number
        if (i == 0) {
            builder.append(1);
            backtrack(word, i + 1, res, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            char top = builder.charAt(builder.length() - 1);
            if (Character.isDigit(top)) { //is digit
                //pop the number
                int start = builder.length() - 1;
                while (0 <= start && Character.isDigit(builder.charAt(start))) {
                    --start;
                }
                ++start;
                String num = builder.substring(start, builder.length());
                String nextNum = addOne(num);
                //append nextNum
                builder.delete(start, builder.length());
                builder.append(nextNum);
                //backtrack
                backtrack(word, i + 1, res, builder);
                //revert
                builder.delete(start, builder.length());
                builder.append(num);
            } else { //is char
                builder.append(1);
                backtrack(word, i + 1, res, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    private String addOne(String num) {
        int carry = 1;
        int i = num.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (0 <= i) {
            char ch = num.charAt(i);
            int sum = ch - '0' + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            --i;
        }
        if (carry != 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }
}
