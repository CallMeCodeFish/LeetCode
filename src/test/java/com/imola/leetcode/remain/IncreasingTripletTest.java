package com.imola.leetcode.remain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/21/20 6:01 PM
 */

/**
 * example 1:
 * Input: [1,2,3,4,5]
 * Output: true
 * <p>
 * example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 */

class IncreasingTripletTest {
    public static void main(String[] args) {
        IncreasingTriplet solution = new IncreasingTriplet();
        int[] nums = new int[]{5,4,3,2,1};
        boolean result = solution.increasingTriplet(nums);
        System.out.println(result);
    }
}