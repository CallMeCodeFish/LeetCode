package com.imola.leetcode.remain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/18/20 2:34 PM
 */

/**
 * example:
 * Input: 4
 * Output: false
 * Explanation: If there are 4 stones in the heap, then you will never win the game;
 *              No matter 1, 2, or 3 stones you remove, the last stone will always be
 *              removed by your friend.
 */

class NimGameTest {
    public static void main(String[] args) {
        NimGame solution = new NimGame();
        boolean result = solution.canWinNim(4);
        System.out.println(result);
    }
}