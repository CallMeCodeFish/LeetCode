package com.imola.oa.netflix;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Heng Yu
 * @date 1/28/20 10:14 PM
 */


class ReassembleNameTest {
    public static void main(String[] args) {
        String name = "John";
        String surName = "Firelord";
        int age = 8;
        ReassembleName solution = new ReassembleName();
        String result = solution.solution(name, surName, age);
        System.out.println(result);
    }
}