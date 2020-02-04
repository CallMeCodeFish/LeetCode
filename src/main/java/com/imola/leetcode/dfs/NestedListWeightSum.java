package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/3/20 4:54 PM
 */

/**
 * leetcode 339: Nested List Weight Sum
 *
 * description:
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * example 1:
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 *
 * example 2:
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//public class NestedListWeightSum {
//    public int depthSum(List<NestedInteger> nestedList) {
//        int res = 0;
//        if (nestedList == null || nestedList.isEmpty())
//            return res;
//
//        for (NestedInteger ni : nestedList) {
//            res += dfs(ni, 1);
//        }
//        return res;
//    }
//
//    private int dfs(NestedInteger ni, int weight) {
//        //edge case
//        int res = 0;
//        if (ni.isInteger()) {
//            res += weight * (ni.getInteger());
//            return res;
//        }
//
//        List<NestedInteger> list = ni.getList();
//        for (NestedInteger e : list) {
//            res += dfs(e, weight + 1);
//        }
//        return res;
//    }
//}

