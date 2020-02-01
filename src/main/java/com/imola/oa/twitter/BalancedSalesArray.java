package com.imola.oa.twitter;

/**
 * @author Heng Yu
 * @date 1/19/20 10:44 AM
 */

import java.util.List;


public class BalancedSalesArray {
    public int solution(List<Integer> sales) {
        int n = sales.size();
        int rightSum = 0;
        for (int i = 1; i < n; ++i) {
            rightSum += sales.get(i);
        }

        int leftSum = sales.get(0);
        int res = 0;

        for (int i = 1; i < n; ++i) {
            leftSum += sales.get(i);
            if (leftSum == rightSum) {
                res = i;
                break;
            }

            rightSum -= sales.get(i);
        }

        return res;
    }
}
