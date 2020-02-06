package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/5/20 7:34 PM
 */

/**
 * leetcode 385: Mini Parser
 *
 * description:
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 *
 * example 1:
 * Given s = "324",
 *
 * You should return a NestedInteger object which contains a single integer 324.
 *
 * example 2:
 * Given s = "[123,[456,[789]]]",
 *
 * Return a NestedInteger object containing a nested list with 2 elements:
 *
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 */

/*
public class MiniParser {
    public NestedInteger deserialize(String s) {
        return dfs(s);
    }

    private NestedInteger dfs(String s) {
        NestedInteger res = new NestedInteger();
        //如果s表示一个Integer
        if (isDigit(s.charAt(0))) { //"324"
            res.setInteger(Integer.parseInt(s));
        } else { //操作list
            int count = 0;
            boolean checkInteger = false; //表示正在check Integer的范围
            int i = 1; //起始位置
            for (int j = 1; j < s.length() - 1; ++j) { //当前位置的指针 "[456,[789]]"
                char cur = s.charAt(j);
                if (0 == count && isDigit(cur)) { //发现Integer
                    if (!checkInteger) { //第一位
                        checkInteger = true;
                        i = j;
                    }

                    if (j + 1 == s.length() - 1 || ',' == s.charAt(j + 1)) { //  Integer结束标志
                        res.add(dfs(s.substring(i, j + 1)));
                        checkInteger = false;
                    }
                } else if ('[' == cur) {
                    if (count == 0) {
                        i = j;
                    }
                    ++count;
                } else if (']' == cur) {
                    --count;
                    if (count == 0) {
                        res.add(dfs(s.substring(i, j + 1)));
                    }
                }
            }
        }

        return res;
    }

    private boolean isDigit(char c) {
        return '-' == c || Character.isDigit(c);
    }
}
 */

