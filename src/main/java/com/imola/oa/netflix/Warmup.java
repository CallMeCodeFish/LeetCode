package com.imola.oa.netflix;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 1/28/20 10:04 PM
 */


public class Warmup {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        for (int i = 1; ; ++i) {
            if (!set.contains(i))
                return i;
        }
    }
}
