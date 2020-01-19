package com.imola.twitter;

import java.util.List;

/**
 * @author Heng Yu
 * @date 1/19/20 3:07 PM
 */

/**
 * 与leetcode 256 paint house相同
 */

public class ColoringTheBlocks {
    public int solution(List<List<Integer>> cost) {
        int n = cost.size();
        int m = 3;

        int[][] dp = new int[n][m];
        for (int i = 0; i < m; ++i) {
            dp[0][i] = cost.get(0).get(i);
        }

        for (int i = 1; i < n; ++i) {
            dp[i][0] = cost.get(i).get(0) + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost.get(i).get(1) + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost.get(i).get(2) + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int res = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        return res;
    }
}
