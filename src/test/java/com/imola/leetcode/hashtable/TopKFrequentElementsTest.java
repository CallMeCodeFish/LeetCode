package com.imola.leetcode.hashtable;

import java.util.List;

/**
 * @author Heng Yu
 * @date 1/19/20 7:45 PM
 */
class TopKFrequentElementsTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 10;
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        List<Integer> solution = topKFrequentElements.solution(nums, k);
        System.out.println(solution);
    }
}