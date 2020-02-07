package com.imola.leetcode.sort;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/6/20 5:37 PM
 */

/**
 * example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * <p>
 * example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * <p>
 * example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */

class ContainsDuplicateIIITest {
    public static void main(String[] args) {
        ContainsDuplicateIII solution = new ContainsDuplicateIII();
        int[] nums = new int[]{-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        boolean result = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(result);
    }
}