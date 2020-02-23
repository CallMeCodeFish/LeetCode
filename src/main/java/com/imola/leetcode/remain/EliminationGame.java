package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/22/20 8:55 PM
 */

/**
 * leetcode 390: Elimination Game
 *
 * description:
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other
 * number afterward until you reach the end of the list.
 *
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other
 * number from the remaining numbers.
 *
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 *
 * Find the last number that remains starting with a list of length n.
 *
 * example:
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * Output:
 * 6
 */

/**
 * reference: https://www.cnblogs.com/grandyang/p/5860706.html
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        return dfs(n, true);
    }

    private int dfs(int n, boolean fromLeft) {
        //edge case
        if (n == 1)
            return 1;

        if (fromLeft) {
            return 2 * dfs(n / 2, false);
        } else {
            if (n % 2 == 1) {
                return 2 * dfs(n / 2, true);
            } else {
                return 2 * dfs(n / 2, true) - 1;
            }
        }
    }
}
