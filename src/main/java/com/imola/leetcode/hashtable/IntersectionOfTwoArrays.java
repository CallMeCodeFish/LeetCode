package com.imola.leetcode.hashtable;

/**
 * @author Heng Yu
 * @date 1/19/20 7:57 PM
 */

import java.util.*;

/**
 * leetcode 349 Intersection of Two Arrays
 *
 * Description: Given two arrays, write a function to compute their intersection.
 *
 * example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 */

public class IntersectionOfTwoArrays {
    public int[] solution(int[] nums1, int[] nums2) {
        //edge case
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num).equals(1)) {
                list.add(num);
                map.replace(num, 0);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = list.get(i);
        }

        return ans;
    }
    /**
     * Arrays.copyOf(nums1, k)函数
     */
}
