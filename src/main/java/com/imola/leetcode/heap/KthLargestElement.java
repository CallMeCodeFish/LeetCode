package com.imola.leetcode.heap;

/**
 * @author Heng Yu
 * @date 2/5/20 10:53 PM
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 215: Kth Largest Element in an Array
 *
 * description:
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : nums) {
            heap.offer(i);
        }

        int res = 0;
        while (k > 0) {
            res = heap.poll();
            --k;
        }
        return res;
    }

    /**
     * 先排序再输出runtime更短
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
