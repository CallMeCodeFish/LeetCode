package com.imola.leetcode.sort;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/6/20 10:43 PM
 */


class WiggleSortIITest {
    public static void main(String[] args) {
        WiggleSortII solution = new WiggleSortII();
        int[] nums = new int[]{5, 3, 1, 2, 6, 7, 8, 5, 5};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}