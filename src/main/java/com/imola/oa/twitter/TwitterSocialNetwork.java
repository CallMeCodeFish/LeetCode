package com.imola.oa.twitter;

import java.util.*;

/**
 * @author Heng Yu
 * @date 1/19/20 4:48 PM
 */
public class TwitterSocialNetwork {
    public int solution(List<String> related) {
        Set<Integer> grouped = new HashSet<>();
        int res = 0;

        for (int i = 0; i < related.size(); ++i) {
            if (grouped.contains(i)) continue;

            char[] network = related.get(i).toCharArray();
            ++res;
            grouped.add(i);
            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < network.length; ++j) {
                if (network[j] == '1' && !grouped.contains(j)) queue.offer(j);
            }

            while (queue.size() != 0) {
                int current = queue.poll();
                grouped.add(current);
                char[] currentNetwork = related.get(current).toCharArray();
                for (int j = 0; j < currentNetwork.length; ++j) {
                    if (currentNetwork[j] == '1' && !grouped.contains(j)) queue.offer(j);
                }
            }
        }

        return res;
    }
}
