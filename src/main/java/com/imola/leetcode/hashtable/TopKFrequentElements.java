package com.imola.leetcode.hashtable;

import java.util.*;

/**
 * @author Heng Yu
 * @date 1/19/20 6:47 PM
 */

/**
 * leetcode 347 top K frequent elements
 * <p>
 * example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */

public class TopKFrequentElements {
    public List<Integer> solution(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.replace(num, counts.get(num) + 1);
            }
        }

        if (counts.keySet().size() <= k) {
            return new ArrayList<>(counts.keySet());
        }

        List<Integer> values = new ArrayList<>(counts.values());
        Collections.sort(values);

        int threshCount = values.get(values.size() - k); // >= 0
        List<Integer> ans = new ArrayList<>();
        for (Integer key : counts.keySet()) {
            if (counts.get(key) >= threshCount) {
                ans.add(key);
            }
        }

        return ans;
    }
}
