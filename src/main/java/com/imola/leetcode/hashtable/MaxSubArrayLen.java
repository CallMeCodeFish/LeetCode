package com.imola.leetcode.hashtable;

/**
 * @author Heng Yu
 * @date 1/18/20 10:29 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * no.325 Maximum size subarray sum equals k
 *
 * example 1:
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 *
 * example 2:
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */

public class MaxSubArrayLen {
    public int solution(int[] nums, int k) {
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == k)
                max = Math.max(max, i + 1);
            else if (map.containsKey(sum - k))
                max = Math.max(max, i - map.get(sum - k));

            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return max;
    }
}
