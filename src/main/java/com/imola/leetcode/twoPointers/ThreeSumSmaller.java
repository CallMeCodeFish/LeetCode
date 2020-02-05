package com.imola.leetcode.twoPointers;

/**
 * @author Heng Yu
 * @date 2/4/20 9:18 PM
 */

import java.util.Arrays;

/**
 * leetcode 259: 3Sum Smaller
 *
 * description:
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * example:
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 *              [-2,0,1]
 *              [-2,0,3]
 *
 * Follow up: Could you solve it in O(n2) runtime?
 */

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length < 3)
            return 0;

        //sort
        Arrays.sort(nums); //O(nlogn)

        int res = 0;
        for (int k = 0; k < nums.length - 2; ++k) {
            int t = target - nums[k]; //target value in this round
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum < t) {
                    res += j - i;
                    ++i;
                } else {
                    --j;
                }
            }
        }
        return res;
    }
}
