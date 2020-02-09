package com.imola.leetcode.backtracking;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/8/20 4:47 PM
 */


class FlipGameIITest {
    public static void main(String[] args) {
        FlipGameII solution = new FlipGameII();
        boolean result = solution.canWin("++++");
        System.out.println(result);
    }
}