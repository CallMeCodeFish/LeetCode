package com.imola.leetcode.remain;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/19/20 9:10 PM
 */

/**
 * example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * (2*((3-4)*5)) = -10
 *
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (((2*3)-4)*5) = 10
 */

class DifferentWaysToAddParenthesesTest {
    public static void main(String[] args) {
        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();
        String input = "2-1-1";
        List<Integer> result = solution.diffWaysToCompute(input);
        System.out.println(result);
    }
}