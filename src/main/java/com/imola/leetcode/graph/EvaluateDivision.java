package com.imola.leetcode.graph;

/**
 * @author Heng Yu
 * @date 2/5/20 8:53 PM
 */

import java.util.*;

/**
 * leetcode 399:  Evaluate Division
 *
 * description:
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a
 * real number (floating point number). Given some queries, return the answers. If the answer does not exist,
 * return -1.0.
 *
 * example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations.
 * Return vector<double>.
 *
 * According to the example above:
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there
 * is no contradiction.
 */

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> variables = new HashMap<>(); //存放每个变量的值
        Map<String, Set<Integer>> indices = new HashMap<>(); //给定一个变量，存放含有该变量的表达式的index
        Map<String, Integer> tokens = new HashMap<>(); //每个变量所在的连通域的编号
        int length = values.length;
        for (int i = 0; i < length; ++i) {
            List<String> equation = equations.get(i);
            for (String v : equation) {
                if (!indices.containsKey(v)) {
                    indices.put(v, new HashSet<>());
                }
                indices.get(v).add(i);
            }
        }

        //traverse the graph
        int token = 0;
        for (String v : indices.keySet()) {
            if (!variables.containsKey(v)) {
                variables.put(v, 1.0);
                dfs(v, variables, indices,equations,values);
                for (String variable : variables.keySet()) {
                    if (!tokens.containsKey(variable)) {
                        tokens.put(variable, token);
                    }
                }
                ++token;
            }
        }

        //deal with queries
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; ++i) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (variables.containsKey(dividend) && variables.containsKey(divisor) && tokens.get(dividend).equals(tokens.get(divisor))) {
                res[i] = variables.get(dividend) / variables.get(divisor);
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    private void dfs(String v, Map<String, Double> variables, Map<String, Set<Integer>> indices, List<List<String>> equations, double[] values) {
        double val = variables.get(v);
        Set<Integer> related = indices.get(v);
        for (int index : related) {
            List<String> equation = equations.get(index);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double expValue = values[index];
            if (v.equals(dividend)) {
                if (!variables.containsKey(divisor)) {
                    variables.put(divisor, val / expValue);
                    dfs(divisor, variables, indices, equations, values);
                }
            } else {
                if (!variables.containsKey(dividend)) {
                    variables.put(dividend, val * expValue);
                    dfs(dividend, variables, indices, equations, values);
                }
            }
        }
    }
}
