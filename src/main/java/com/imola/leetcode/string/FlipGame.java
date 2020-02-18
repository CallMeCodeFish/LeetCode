package com.imola.leetcode.string;

/**
 * @author Heng Yu
 * @date 2/18/20 1:53 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 293: Flip Game
 *
 * description:
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
 * + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * example:
 * Input: s = "++++"
 * Output:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 *
 * Note: If there is no valid move, return an empty list [].
 */

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.length() < 2)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); ++i) {
            if ('-' == s.charAt(i) || '-' == s.charAt(i - 1))
                continue;
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i - 1));
            sb.append("--");
            sb.append(s.substring(i + 1));
            res.add(sb.toString());
        }
        return res;
    }
}
