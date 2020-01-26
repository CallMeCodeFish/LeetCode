package com.imola.leetcode.linkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 1/25/20 12:07 PM
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Queue<TreeNode> q = new LinkedList<>();
        if (this != null)
            q.offer(this);

        while (q.size() != 0) {
            int size = q.size();
            if (sb.length() > 1)
                sb.append(", ");

            StringBuilder temp = new StringBuilder();
            temp.append('[');

            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                if (temp.length() > 1)
                    temp.append(", ");

                temp.append(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            temp.append(']');
            sb.append(temp);
        }

        sb.append(']');
        return sb.toString();
    }
}
