package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/21/20 3:33 PM
 */

/**
 * leetcode 307: Range Sum Query
 *
 * description:
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * example:
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class RangeSumQuery {
    private int[] sums;

    public RangeSumQuery(int[] nums) {
        this.sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            this.sums[i] = sum;
        }
    }

    public void update(int i, int val) {
        int old = 0;
        if (i == 0) {
            old = sums[i];
        } else {
            old = sums[i] - sums[i - 1];
        }
        while (i < sums.length) {
            sums[i++] += (val - old);
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sums[j];
        return sums[j] - sums[i - 1];
    }
}


/**
 * method: segment tree
 * reference: https://blog.csdn.net/weixin_34417635/article/details/91957042
 */
class RangeSumQuery2 {
    private class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    private SegmentTreeNode root;

    public RangeSumQuery2 (int[] nums) {
        if (nums != null && nums.length != 0)
            this.root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public void update(int i, int val) {
        updateHelper(root, i, val);
    }

    private void updateHelper(SegmentTreeNode node, int i, int val) {
        //edge case
        if (node.start == node.end) {
            node.sum = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) {
            updateHelper(node.left, i, val);
        } else {
            updateHelper(node.right, i, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        int ret = getSum(root, j);
        if (i != 0) {
            ret -= getSum(root, i - 1);
        }
        return ret;
    }

    private int getSum(SegmentTreeNode node, int r) {
        int ret = 0;
        if (r == node.end) {
            ret = node.sum;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (r <= mid) {
                ret = getSum(node.left, r);
            } else {
                ret = node.left.sum + getSum(node.right, r);
            }
        }
        return ret;
    }
}