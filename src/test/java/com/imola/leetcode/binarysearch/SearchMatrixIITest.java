package com.imola.leetcode.binarysearch;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/3/20 7:39 PM
 */

/**
 * example:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */

class SearchMatrixIITest {
    public static void main(String[] args) {
        SearchMatrixII solution = new SearchMatrixII();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean result = solution.searchMatrix(matrix, 20);
        System.out.println(result);
    }
}