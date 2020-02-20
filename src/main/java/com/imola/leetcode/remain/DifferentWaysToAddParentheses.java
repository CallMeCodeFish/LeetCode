package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/19/20 8:25 PM
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 241: Different Ways to Add Parentheses
 *
 * description:
 * Given a string of numbers and operators, return all possible results from computing all the different possible
 * ways to group numbers and operators. The valid operators are +, - and *.
 *
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
 * ((2*3)-(4*5)) = -14
 * (((2*3)-4)*5) = 10
 *
 * (2*((3-4)*5)) = -10
 * ((2*(3-4))*5) = -10
 *
 * (2*(3-(4*5))) = -34
 */

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> optrs = new ArrayDeque<>();

        backtrack(input, 0, nums, optrs, res);
        return res;
    }

    private void backtrack(String s, int i, Deque<Integer> nums, Deque<Character> optrs, List<Integer> res) {
        //edge case
        if (s.length() == i) {
            if (!optrs.isEmpty()) {
                Deque<Integer> copyNums = new ArrayDeque<>(nums);
                Deque<Character> copyOptrs = new ArrayDeque<>(optrs);
                while (!copyOptrs.isEmpty()) {
                    char optr = copyOptrs.pop();
                    int second = copyNums.pop();
                    int first = copyNums.pop();
                    int result = calcResult(first, second, optr);
                    copyNums.push(result);
                }
                res.add(copyNums.pop());
            } else {
                res.add(nums.peek());
            }
            return;
        }

        char ch = s.charAt(i);
        if (Character.isDigit(ch)) { //digit
            int j = i + 1;
            while (j < s.length()) {
                if (!Character.isDigit(s.charAt(j)))
                    break;
                ++j;
            }
            int num = Integer.parseInt(s.substring(i, j));
            if (!optrs.isEmpty() && j < s.length()) {
                Deque<Integer> copyNums = new ArrayDeque<>(nums);
                Deque<Character> copyOptrs = new ArrayDeque<>(optrs);
                int second = num;
                while (!copyOptrs.isEmpty()) {
                    char optr = copyOptrs.pop();
                    int first = copyNums.pop();
                    second = calcResult(first, second, optr);
                    copyNums.push(second);
                    backtrack(s, j, copyNums, copyOptrs, res);
                    copyNums.pop();
                }
            }
            nums.push(num);
            backtrack(s, j, nums, optrs, res);
            nums.pop();
        } else { //operator
            optrs.push(ch);
            backtrack(s, i + 1, nums, optrs, res);
            optrs.pop();
        }
    }

    private int calcResult(int first, int second, char optr) {
        int res = 0;
        if ('+' == optr) {
            res = first + second;
        } else if ('-' == optr) {
            res = first - second;
        } else { //'*'
            res = first * second;
        }
        return res;
    }
}
