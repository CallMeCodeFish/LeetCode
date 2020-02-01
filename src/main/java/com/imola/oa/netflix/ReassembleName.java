package com.imola.oa.netflix;

/**
 * @author Heng Yu
 * @date 1/28/20 10:11 PM
 */


public class ReassembleName {
    public String solution(String name, String surname, int age) {
        // write your code in Java SE 8
        StringBuilder builder = new StringBuilder();
        builder.append(name.substring(0, 2));
        builder.append(surname.substring(0, 2));
        builder.append(age);
        return builder.toString();
    }
}
