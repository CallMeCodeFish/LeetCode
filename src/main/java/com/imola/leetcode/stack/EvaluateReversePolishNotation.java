package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/4/20 9:47 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 150: Evaluate Reverse Polish Notation
 *
 * desciption:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there
 * won't be any divide by zero operation.
 *
 * example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.length() > 1 || Character.isDigit(token.charAt(0))) {
                stack.push(Integer.valueOf(token));
            } else {
                Integer second = stack.pop();
                Integer first = stack.pop();
                Integer result = operate(first, second, token);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private Integer operate(Integer first, Integer second, String operator) {
        if ("+".equals(operator)) {
            //add
            return first + second;
        } else if ("-".equals(operator)) {
            //subtract
            return first - second;
        } else if ("*".equals(operator)) {
            //multiply
            return first * second;
        } else { // "/"
            //divide
            return first / second;
        }
    }
}
