package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/8/20 4:53 PM
 */

/**
 * leetcode 306: Additive Number
 *
 * description:
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
 * number in the sequence must be the sum of the preceding two.
 *
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * example 1:
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * example 2:
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 *              1 + 99 = 100, 99 + 100 = 199
 *
 * Constraints:
 *
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * Follow up:
 * How would you handle overflow for very large input integers?
 */

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        //edge case
        if (num == null || num.length() < 3)
            return false;

        return backtrack(num, 0, "", "");
    }

    private boolean backtrack(String num, int i, String s1, String s2) {
        //edge case
        if (i == num.length())
            return true;

        if ("".equals(s1) && "".equals(s2)) {
            for (int j = i + 1; j <= num.length(); ++j) {
                if (num.length() - j < j - i)
                    return false;
                String substring = num.substring(i, j);
                if ('0' == substring.charAt(0) && substring.length() > 1)
                    return false;
                boolean res = backtrack(num, j, s1, substring);
                if (res)
                    return true;
            }
        } else if ("".equals(s1)) {
            for (int j = i + 1; j <= num.length(); ++j) {
                if (num.length() - j < j - i || num.length() < s2.length())
                    return false;
                String substring = num.substring(i, j);
                if ('0' == substring.charAt(0) && substring.length() > 1)
                    return false;
                boolean res = backtrack(num, j, s2, substring);
                if (res)
                    return true;
            }
        } else {
            String sum = getSum(s1, s2);
            int length = sum.length();
            int j = i + length;
            if (num.length() < j || !sum.equals(num.substring(i, j)))
                return false;
            String substring = num.substring(i, j);
            if ('0' == substring.charAt(0) && substring.length() > 1)
                return false;
            boolean res = backtrack(num, i + length, s2, substring);
            if (res)
                return true;
        }
        return false;
    }

    private String getSum(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (0 <= i || 0 <= j) {
            int digit1 = 0;
            if (0 <= i) {
                digit1 = num1.charAt(i--) - '0';
            }
            int digit2 = 0;
            if (0 <= j) {
                digit2 = num2.charAt(j--) - '0';
            }
            int sum = digit1 + digit2 + carry;
            builder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
