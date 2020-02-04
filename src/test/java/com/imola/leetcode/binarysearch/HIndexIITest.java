package com.imola.leetcode.binarysearch;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/3/20 9:01 PM
 */

/**
 * example:
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 */

class HIndexIITest {
    public static void main(String[] args) {
        HIndexII solution = new HIndexII();
        int[] citations = new int[]{0, 1, 3, 5, 6};
        int result = solution.hIndex(citations);
        System.out.println(result);
    }
}