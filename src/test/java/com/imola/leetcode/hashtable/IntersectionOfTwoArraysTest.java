package com.imola.leetcode.hashtable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/19/20 8:21 PM
 */
class IntersectionOfTwoArraysTest {
    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};

        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] solution = intersectionOfTwoArrays.solution(nums1, nums2);
        String string = Arrays.toString(solution);
        System.out.println(string);
    }
}