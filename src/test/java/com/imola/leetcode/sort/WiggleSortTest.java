package com.imola.leetcode.sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/6/20 8:59 PM
 */

/**
 * 3,5,2,1,6,4
 */

class WiggleSortTest {
    public static void main(String[] args) {
        WiggleSort solution = new WiggleSort();
        int[] nums = new int[]{1, 2, 3, 4};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}