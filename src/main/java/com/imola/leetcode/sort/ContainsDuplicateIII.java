package com.imola.leetcode.sort;

/**
 * @author Heng Yu
 * @date 2/6/20 4:53 PM
 */

import java.util.TreeSet;

/**
 * leetcode 220: Contains Duplicate III
 *
 * description:
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at
 * most k.
 *
 * example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * example 2:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */

/**
 * 解析：https://segmentfault.com/a/1190000018241839
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //edge case
        if(nums == null || nums.length < 2 || k < 1 || t < 0){
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!treeSet.subSet((long) nums[i] - t, true, (long) nums[i] + t, true).isEmpty()) {
                return true;
            }
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
            treeSet.add((long) nums[i]);
        }

        return false;
    }
}
