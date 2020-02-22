package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/21/20 5:31 PM
 */

/**
 * leetcode 334: Increasing Triplet Subsequence
 *
 * description:
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 *
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * example 1:
 * Input: [1,2,3,4,5]
 * Output: true
 *
 * example 2:
 * Input: [5,4,3,2,1]
 * Output: false
 */

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        //edge case
        if (nums == null || nums.length < 3)
            return false;

        int finalCount = 1;
        int finalFirstIndex = 0;
        int finalSecondIndex = -1;
        int finalLast = nums[0];
        int count = 0;
        int firstIndex = 0;
        int secondIndex = -1;
        int last = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            if (finalLast < num) {
                ++finalCount;
                if (finalCount == 3)
                    return true;
                finalSecondIndex = i;
                finalLast = nums[i];
            } else {
                if (finalCount == 1 && nums[i] < nums[finalFirstIndex]) {
                    finalFirstIndex = i;
                    finalLast = nums[i];
                } else if (finalCount == 2 && nums[finalFirstIndex] < nums[i] && nums[i] < nums[finalSecondIndex]) {
                    finalSecondIndex = i;
                    finalLast = nums[i];
                }
            }
            if (last < num) {
                ++count;
                secondIndex = i;
                last = num;
                if (count == finalCount && last < finalLast) {
                    finalLast = last;
                    finalFirstIndex = firstIndex;
                    finalSecondIndex = secondIndex;
                }
            } else {
                if (count == 1 && num < nums[firstIndex]) {
                    firstIndex = i;
                    last = num;
                } else if (count == 2) {
                    if (num <= nums[firstIndex]) {
                        count = 1;
                        firstIndex = i;
                        last = num;
                    } else if (nums[firstIndex] < num && num < nums[secondIndex]) {
                        secondIndex = i;
                        last = num;
                    }
                }
            }
        }
        return false;
    }

    /**
     * reference: 0 ms answer
     * @param nums
     * @return
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < n1) {
                n1 = num;
            } else if (n1 < num && num < n2) {
                n2 = num;
            } else if (n2 < num) {
                return true;
            }
        }
        return false;
    }
}
