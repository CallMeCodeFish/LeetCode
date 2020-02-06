package com.imola.leetcode.heap;

/**
 * @author Heng Yu
 * @date 2/5/20 11:12 PM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode 373: Find K Pairs with Smallest Sums
 *
 * description:
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * example 3:
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */

public class FindKPairsWithSmallestSums {
    private class Pair implements Comparable<Pair> {
        int sum;
        int index;
        List<Integer> nums;

        public Pair(int n1, int n2, int index) {
            this.nums = new ArrayList<>();
            nums.add(n1);
            nums.add(n2);
            this.sum = n1 + n2;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.sum - pair.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //edge case
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return res;

        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            if (nums2.length == i)
                break;
            heap.offer(new Pair(nums1[0], nums2[i], 0));
        }

        while (k > 0) {
            if (heap.isEmpty()) {
                break;
            }
            Pair pair = heap.poll();
            res.add(pair.nums);

            int index = pair.index;
            if (++index < nums1.length)
                heap.offer(new Pair(nums1[index], pair.nums.get(1), index));
            --k;
        }
        return res;
    }
}
