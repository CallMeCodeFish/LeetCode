package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/21/20 8:59 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 386: Lexicographical Numbers
 *
 * description:
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        //edge case
        if (n <= 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(0, res, n);
        return res;
    }

    private void dfs(int base, List<Integer> res, int n) { //n = 100
        for (int i = 1; i < 10; ++i) {
            int num = base + i;
            if (num <= n) {
                res.add(num);
                int nextBase = num * 10;
                while (nextBase <= n) {
                    res.add(nextBase);
                    nextBase *= 10;
                }
                while (num < nextBase) {
                    if (nextBase <= n) {
                        dfs(nextBase, res, n);
                    }
                    nextBase /= 10;
                }
            } else {
                break;
            }
        }
    }
}
