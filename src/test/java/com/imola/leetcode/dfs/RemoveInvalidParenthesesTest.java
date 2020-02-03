package com.imola.leetcode.dfs;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/2/20 11:30 PM
 */

/**
 * example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 * example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 * example 3:
 * Input: ")("
 * Output: [""]
 */

class RemoveInvalidParenthesesTest {
    public static void main(String[] args) {
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
        List<String> result = solution.removeInvalidParentheses("(((k()((");
        System.out.println(result);
    }
}