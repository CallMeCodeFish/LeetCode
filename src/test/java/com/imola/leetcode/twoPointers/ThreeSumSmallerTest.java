package com.imola.leetcode.twoPointers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/4/20 9:37 PM
 */

/**
 * example:
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 */

class ThreeSumSmallerTest {
    public static void main(String[] args) {
        ThreeSumSmaller solution = new ThreeSumSmaller();
        int[] nums = new int[]{-2, 0, 1, 3};
        int result = solution.threeSumSmaller(nums, 2);
        System.out.println(result);
    }
}