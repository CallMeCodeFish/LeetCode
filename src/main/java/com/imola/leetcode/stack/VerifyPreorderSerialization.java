package com.imola.leetcode.stack;

/**
 * @author Heng Yu
 * @date 2/5/20 3:50 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 331: Verify Preorder Serialization of a Binary Tree
 *
 * description:
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the
 * node's value. If it is a null node, we record using a sentinel value such as #.
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents
 * a null node.
 *
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a
 * binary tree. Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas
 * such as "1,,3".
 *
 * example 1:
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 *
 * example 2:
 * Input: "1,#"
 * Output: false
 *
 * example 3:
 * Input: "9,#,#,1"
 * Output: false
 */

public class VerifyPreorderSerialization {
    private class StatusNode {
        int value;
        int status; // 0 1 2

        public StatusNode(int value, int status) {
            this.value = value;
            this.status = status;
        }
    }

    public boolean isValidSerialization(String preorder) { //"9,3,4,#,#,1,#,#,2,#,6,#,#"
        //edge case
        if (preorder == null || preorder.length() < 1)
            return false;

        Deque<StatusNode> stack = new ArrayDeque<>(); // 9(1) 2(1)
        String[] split = preorder.split(",");
        for (int i = 0; i < split.length; ++i) {
            if (stack.isEmpty() && i != 0) {
                return false;
            }
            char cur = split[i].charAt(0);
            if (Character.isDigit(cur)) { //当前字符是数字
                StatusNode node = new StatusNode(cur - '0', 0);
                stack.push(node);
            } else { //当前字符是'#'
                while (!stack.isEmpty()) {
                    StatusNode node = stack.poll(); //9(1)
                    ++node.status; //9(2)
                    if (node.status < 2) {
                        stack.push(node);
                        break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
