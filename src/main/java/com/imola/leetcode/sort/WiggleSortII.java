package com.imola.leetcode.sort;

/**
 * @author Heng Yu
 * @date 2/6/20 10:15 PM
 */

import java.util.Arrays;

/**
 * leetcode 324: Wiggle Sort II
 * <p>
 * description:
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * example 1:
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * <p>
 * example 2:
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * <p>
 * example 3:
 * input: [1,2,2,1,2,1,1,1,1,2,2,2]  ->  [1,2,1,2,1,2,1,2,1,2,1,2]
 * output: [1,2,1,2,1,2,1,2,1,2,1,2]
 * <p>
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        //edge case
        if (nums == null || nums.length < 2)
            return;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //这个题只能从前后半段的最后一个元素开始往回写
        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;
        int k = 0;
        int[] temp = new int[nums.length];
        while (left >= 0) {
            temp[k++] = nums[left--];
            if (k < temp.length)
                temp[k++] = nums[right--];
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = temp[i];
        }
    }
}
