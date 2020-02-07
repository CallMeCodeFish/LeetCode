package com.imola.leetcode.sort;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/6/20 11:00 AM
 */

/**
 * example 1:
 * Input: [10,2]
 * Output: "210"
 * <p>
 * example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 */

class LargestNumberTest {
    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
//        int[] nums = new int[]{8247,938, 9609};
        int[] nums = new int[]{3, 30};
        String result = solution.largestNumber(nums);
        System.out.println("result: " + result);
    }
}