package com.imola.leetcode.remain;

/**
 * @author Heng Yu
 * @date 2/21/20 9:41 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 388: Longest Absolute File Path
 *
 * description:
 * Suppose we abstract our file system by a string in the following manner:
 *
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 *
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *             file2.ext
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty
 * second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file
 * file2.ext.
 *
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For
 * example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its
 * length is 32 (not including the double quotes).
 *
 * Given a string representing the file system in the above format, return the length of the longest absolute path to
 * file in the abstracted file system. If there is no file in the system, return 0.
 *
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 *
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */

public class LongestAbsoluteFilePath {
    private class FileNode {
        String name;
        int maxLength;
        List<FileNode> children;

        public FileNode(String name) {
            this.name = name;
            this.maxLength = 0;
            this.children = new ArrayList<>();
        }

        public FileNode() {
            this.name = "";
            this.maxLength = 0;
            this.children = new ArrayList<>();
        }
    }

    public int lengthLongestPath(String input) {
        //edge case

        String[] splits = input.split("\\n");
        FileNode root = new FileNode();
        char sep = '\t';
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch == '\t' || ch == ' ') {
                if (ch == ' ')
                    sep = ch;
                break;
            }
        }
        dfs(root, 0, splits, 0, sep);
        if (root.maxLength == 0)
            return 0;
        return root.maxLength - 1;
    }

    private int dfs(FileNode node, int space, String[] splits, int cur, char sep) {
        //edge case
        if (node.name.split("\\.").length > 1) {
            node.maxLength = node.name.length();
            return cur;
        }

        while (cur < splits.length) {
            String str = splits[cur];
            int count = 0;
            for (int i = 0; i < str.length(); ++i) {
                if (sep == str.charAt(i)) {
                    ++count;
                } else {
                    break;
                }
            }
            int inc = 1;
            if (' ' == sep)
                inc = 4;
            if (count >= space) {
                String prefix = "";
                if (count > space) {
                    int prefixLength = count - space;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < prefixLength; ++i) {
                        sb.append(' ');
                    }
                    prefix = sb.toString();
                }
                FileNode child = null;
                if ('\t' == sep) {
                    String[] names = str.split("\\t");
                    String name = names[names.length - 1];
                    child = new FileNode(name);
                } else {
                    child = new FileNode(prefix + str.trim());
                }
                node.children.add(child);
                cur = dfs(child, space + inc, splits, cur + 1, sep);
            } else { //count < space
                break;
            }
        }
        int max = 0;
        for (FileNode child : node.children) {
            if (child.maxLength > 0) {
                max = Math.max(max, child.maxLength);
            }
        }
        if (max > 0) {
            node.maxLength = node.name.length() + max + 1;
        }
        return cur;
    }
}
