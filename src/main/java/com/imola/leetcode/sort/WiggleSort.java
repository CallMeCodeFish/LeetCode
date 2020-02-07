package com.imola.leetcode.sort;

/**
 * @author Heng Yu
 * @date 2/6/20 8:39 PM
 */

/**
 * leetcode 280: Wiggle Sort
 * <p>
 * description:
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * example:
 * Input: nums = [3,5,2,1,6,4]  [1,2,3,4,5,6] [1,3,2,5,4,6]
 * Output: One possible answer is [3,5,1,6,2,4]
 * <p>
 * example:
 * input: [1,2,3,4,5,6,7] [1,3,2,5,4,7,6]
 * output: [1,3,2,5,4,7,6]
 * <p>
 * example:
 * input: 1,2,3,4
 * output: 1,3,2,4
 */

public class WiggleSort {
    public void myWiggleSort(int[] nums) {
        //edge case
        if (nums == null || nums.length < 2)
            return;

        //quick sort
        quickSort(nums, 0, nums.length - 1);

        //wiggle sort
        //方法: 第二个i = 2开始，将每一个index为偶数的元素与i - 1进行交换
        for (int i = 2; i < nums.length; i += 2) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = temp;
        }

    }

    private void quickSort(int[] nums, int left, int right) {
        //edge case
        if (right <= left)
            return;

        int l = left;
        int r = right;
        int length = right - left + 1;
        int randIndex = (int) (Math.random() * (length)) + left;
        //swap
        int pivot = nums[left];
        nums[left] = nums[randIndex];
        nums[randIndex] = pivot;
        pivot = nums[left];
        //quick sort
        boolean isRight = true;
        while (left < right) {
            if (isRight) {
                //move the right pointer
                while (left < right && pivot <= nums[right]) {
                    --right;
                }
                if (left < right) {
                    nums[left++] = nums[right];
                    isRight = false;
                }
            } else {
                //move the left pointer
                while (left < right && nums[left] <= pivot) {
                    ++left;
                }
                if (left < right) {
                    nums[right--] = nums[left];
                    isRight = true;
                }
            }
        }
        nums[left] = pivot;
        //dfs
        quickSort(nums, l, left - 1);
        quickSort(nums, left + 1, r);
    }

    public void wiggleSort(int[] nums) {
        //edge case
        if (nums == null || nums.length < 2)
            return;

        for (int i = 0; i < nums.length - 1; ++i) {
            if (i % 2 == 0 && nums[i] > nums[i + 1] || i % 2 == 1 && nums[i] < nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}
