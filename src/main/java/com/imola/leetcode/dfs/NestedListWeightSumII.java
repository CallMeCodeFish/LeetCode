package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/3/20 5:21 PM
 */

/**
 * leetcode 364: Nested List Weight Sum II
 *
 * description:
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from
 * bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 * example 1:
 * Input: [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's at depth 1, one 2 at depth 2.
 *
 * example 2:
 * Input: [1,[4,[6]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */

//public class NestedListWeightSumII {
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        //edge case
//        if (nestedList == null || nestedList.isEmpty())
//            return 0;
//
//        int depth = 0;
//        for (NestedInteger ni : nestedList) {
//            depth = Math.max(depth, getDepth(ni));
//        }
//        ++depth;
//
//        int res = 0;
//        for (NestedInteger ni : nestedList) {
//            res += getSum(ni, depth);
//        }
//
//        return res;
//    }
//
//    private int getSum(NestedInteger ni, int weight) {
//        if (ni.isInteger()) {
//            return weight * ni.getInteger();
//        }
//
//        List<NestedInteger> list = ni.getList();
//        int res = 0;
//        for (NestedInteger e: list) {
//            res += getSum(e, weight - 1);
//        }
//        return res;
//    }
//
//    private int getDepth(NestedInteger ni) {
//        if (ni.isInteger()) {
//            return 0;
//        }
//
//        List<NestedInteger> list = ni.getList();
//        int depth = 0;
//        for (NestedInteger e : list) {
//            depth = Math.max(depth, getDepth(e));
//        }
//        ++depth;
//        return depth;
//    }
//}
