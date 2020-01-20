package com.imola.leetcode.hashtable;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 1/19/20 8:45 PM
 */
class IntersectionOfTwoArraysIITest {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 4, 4, 5, 9};
        int[] nums2 = new int[]{4, 4, 8, 9, 9};

        IntersectionOfTwoArraysII intersect = new IntersectionOfTwoArraysII();
        int[] solution = intersect.solution2(nums1, nums2);
        String string = Arrays.toString(solution);
        System.out.println(string);
    }
}