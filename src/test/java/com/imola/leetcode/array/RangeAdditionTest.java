package com.imola.leetcode.array;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/15/20 8:16 PM
 */

/**
 * example:
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 */

class RangeAdditionTest {
    public static void main(String[] args) {
        RangeAddition solution = new RangeAddition();
        int[][] updates = new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] result = solution.getModifiedArray2(5, updates);
        System.out.println(Arrays.toString(result));
    }
}