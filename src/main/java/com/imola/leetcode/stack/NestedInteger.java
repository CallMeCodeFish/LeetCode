package com.imola.leetcode.stack;

import java.util.List;

/**
 * @author Heng Yu
 * @date 2/5/20 5:34 PM
 */


interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    void add(NestedInteger ni);

    List<NestedInteger> getList();
}
