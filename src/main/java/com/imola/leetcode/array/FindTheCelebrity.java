package com.imola.leetcode.array;

/**
 * @author Heng Yu
 * @date 2/15/20 7:16 PM
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 277: Find the Celebrity
 *
 * description:
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do
 * is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the
 * celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int
 * findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if
 * there is a celebrity in the party. If there is no celebrity, return -1.
 *
 * example 1:
 * Input: graph = [
 *   [1,1,0],
 *   [0,1,0],
 *   [1,1,1]
 * ]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
 * otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because
 * both 0 and 2 know him but 1 does not know anybody.
 *
 * example 2:
 * Input: graph = [
 *   [1,0,1],
 *   [1,1,0],
 *   [0,1,1]
 * ]
 * Output: -1
 * Explanation: There is no celebrity.
 *
 * Note:
 *
 * The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means person i
 * knows person j while a[i][j] = 0 means the contrary.
 * Remember that you won't have direct access to the adjacency matrix.
 */

public class FindTheCelebrity {
    public int findCelebrity(int n) {
        Set<Integer> known = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (knows(0, i))
                known.add(i);
        }

        for (int i = 1; i < n; ++i) {
            List<Integer> unknown = new ArrayList<>();
            for (int j : known) {
                if (!knows(i, j))
                    unknown.add(j);
            }
            for (int j : unknown) {
                known.remove(j);
            }
            if (known.isEmpty())
                return -1;
        }

        int result = -1;
        if (known.size() > 1)
            return result;

        for (int i : known) {
            result = i;
        }

        for (int i = 0; i < n; ++i) {
            if (result != i) {
                if (knows(result, i))
                    return -1;
            }
        }
        return result;
    }

    private boolean knows(int a, int b) {
        return false;
    }

    /**
     * reference https://www.jianshu.com/p/dca466058b1c
     * @param n
     * @return
     */
    public int findCelebrity2(int n) {
        //edge case

        int res = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(res, i)) {
                res = i;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!knows(i, res) || res != i && knows(res, i))
                return -1;
        }

        return res;
    }
}
