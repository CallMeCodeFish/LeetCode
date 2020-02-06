package com.imola.leetcode.stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 2/5/20 4:47 PM
 */

/**
 * example 1:
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * <p>
 * example 2:
 * Input: "1,#"
 * Output: false
 * <p>
 * example 3:
 * Input: "9,#,#,1"
 * Output: false
 */

class VerifyPreorderSerializationTest {
    public static void main(String[] args) {
        VerifyPreorderSerialization solution = new VerifyPreorderSerialization();
        String preorder = "";
        boolean result = solution.isValidSerialization(preorder);
        System.out.println(result);
    }
}