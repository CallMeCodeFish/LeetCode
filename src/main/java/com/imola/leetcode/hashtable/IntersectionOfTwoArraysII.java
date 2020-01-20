package com.imola.leetcode.hashtable;

/**
 * @author Heng Yu
 * @date 1/19/20 8:35 PM
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 350 Intersection of Two Arrays II
 * <p>
 * Description: Given two arrays, write a function to compute their intersection.
 * <p>
 * example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 */

public class IntersectionOfTwoArraysII {
    public int[] solution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.replace(i, map.get(i) + 1);
            }
        }

        int j = 0;
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                nums1[j++] = i;
                map.replace(i, map.get(i) - 1);
            }
        }

        return Arrays.copyOf(nums1, j);
    }

    /**
     * follow up 1: What if the given array is already sorted? How would you optimize your algorithm?
     */
    public int[] solution2(int[] nums1, int[] nums2) {
        int pos1 = 0;
        int pos2 = 0;
        int[] ans = new int[nums1.length];
        int k = 0;

        while (pos1 < nums1.length && pos2 < nums2.length) {
            int num1 = nums1[pos1];
            int num2 = nums2[pos2];
            if (num1 == num2) {
                ans[k++] = num1;
                pos1++;
                pos2++;
            } else if (num1 < num2) {
                pos1++;
            } else {
                pos2++;
            }
        }

        return Arrays.copyOf(ans, k);
    }

}
