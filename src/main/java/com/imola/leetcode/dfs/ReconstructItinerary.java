package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/3/20 10:55 AM
 */

import java.util.*;

/**
 * leetcode 332: Reconstruct Itinerary
 * <p>
 * description:
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 * read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * <p>
 * example 1:
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * <p>
 * example 2:
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */

/**
 * https://www.bilibili.com/video/av81449009?from=search&seid=10594693553746870623
 */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjacency = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!adjacency.containsKey(from)) {
                adjacency.put(from, new PriorityQueue<>());
            }
            adjacency.get(from).offer(to);
        }

        Deque<String> stack = new ArrayDeque<>();
        dfs("JFK", adjacency, stack);
        while (stack.size() != 0) {
            res.add(stack.pop());
        }
        return res;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> adjacency, Deque<String> stack) {
        PriorityQueue<String> destinations = adjacency.get(from);
        while (destinations != null && destinations.size() != 0) {
            String to = destinations.poll();
            dfs(to, adjacency, stack);
        }
        stack.push(from);
    }
}
