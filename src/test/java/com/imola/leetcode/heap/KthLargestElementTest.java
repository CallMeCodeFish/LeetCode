package com.imola.leetcode.heap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/5/20 10:58 PM
 */

/**
 * example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */

class KthLargestElementTest {
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result);
    }
}