package com.imola.leetcode.backtracking;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/8/20 9:44 PM
 */

/**
 * example:
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

class GeneralizedAbbreviationTest {
    public static void main(String[] args) {
        GeneralizedAbbreviation solution = new GeneralizedAbbreviation();
        List<String> result = solution.generateAbbreviations("word");
        System.out.println(result);
    }
}