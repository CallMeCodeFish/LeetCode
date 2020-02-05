package com.imola.leetcode.binarysearch;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/4/20 11:23 AM
 */

/**
 * example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 */

class KthSmallestElementTest {
    public static void main(String[] args) {
        KthSmallestElement solution = new KthSmallestElement();
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int result = solution.kthSmallest(matrix, 8);
        System.out.println(result);
    }
}