package com.imola.leetcode.backtracking;

/**
 * @author Heng Yu
 * @date 2/8/20 3:52 PM
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 294: Flip Game II
 * <p>
 * description:
 * You are playing the following Flip Game with your friend: Given a string that contains only these two
 * characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a
 * person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * example:
 * Input: s = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * <p>
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */

/**
 * 解析: https://blog.csdn.net/chaochen1407/article/details/82687130
 */

public class FlipGameII {
    public boolean canWin(String s) {
        return backtrack(s.toCharArray(), new HashMap<>());
    }

    private boolean backtrack(char[] chs, Map<String, Boolean> memo) {
        String s = new String(chs);
        if (memo.containsKey(s))
            return memo.get(s);

        boolean res = false;
        for (int i = 1; i < chs.length; ++i) {
            if ('+' == chs[i - 1] && '+' == chs[i]) {
                chs[i - 1] = chs[i] = '-';
                if (!backtrack(chs, memo)) {
                    res = true;
                    chs[i - 1] = chs[i] = '+';
                    break;
                }
                chs[i - 1] = chs[i] = '+';
            }
        }
        memo.put(s, res);
        return res;
    }
}
