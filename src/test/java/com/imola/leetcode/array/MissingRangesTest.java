package com.imola.leetcode.array;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/15/20 5:02 PM
 */

/**
 * example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */

class MissingRangesTest {
    public static void main(String[] args) {
        MissingRanges solution = new MissingRanges();
        int[] nums = new int[]{50, 60, 89};
        List<String> result = solution.findMissingRanges(nums, 0, 90);
        System.out.println(result);
    }
}