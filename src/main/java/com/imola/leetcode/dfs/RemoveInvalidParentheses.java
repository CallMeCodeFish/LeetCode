package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/2/20 10:28 PM
 */

import java.util.*;

/**
 * leetcode 301: Remove Invalid Parentheses
 * <p>
 * description:
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible
 * results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * <p>
 * example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * <p>
 * example 3:
 * Input: ")("
 * Output: [""]
 */

public class RemoveInvalidParentheses {
    /**
     * 思路讲解 https://segmentfault.com/a/1190000013676627
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        removeInvalidParentheses(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }



    public void removeInvalidParentheses(String s, List<String> result, int lastRemoveIndex, int lastCheckedIndex, char[] pattern){
        for(int stack = 0, i = lastCheckedIndex ; i<s.length() ; i++){
            int cur = s.charAt(i);
            if(cur == pattern[0]) stack++;
            if(cur == pattern[1]) stack--;
            if(stack>=0) continue;
            for(int j = lastRemoveIndex ; j <= i ; j++){
                if(s.charAt(j)==pattern[1] && (j == lastRemoveIndex || s.charAt(j-1)!=pattern[1])){
                    removeInvalidParentheses(s.substring(0, j) + s.substring(j+1), result, j, i, pattern);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(pattern[0] == '('){
            removeInvalidParentheses(reversed, result, 0, 0, new char[]{')', '('});
        }else{
            result.add(reversed);
        }
    }
}
