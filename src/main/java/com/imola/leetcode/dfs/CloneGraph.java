package com.imola.leetcode.dfs;

/**
 * @author Heng Yu
 * @date 2/1/20 11:10 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 133: Clone Graph
 * <p>
 * description:
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */

public class CloneGraph {
    public Node cloneGraph(Node node) {
        //edge case
        if (node == null)
            return null;

        Node res = new Node(node.val);
        Map<Node, Node> nodes = new HashMap<>();
        nodes.put(node, res);
        dfs(node, nodes);
        return res;
    }

    private void dfs(Node node, Map<Node, Node> nodes) {
        Node curNode = nodes.get(node);
        for (Node neighbor : node.neighbors) {
            Node curNeighbor = null;
            if (nodes.containsKey(neighbor)) {
                curNeighbor = nodes.get(neighbor);
                curNode.neighbors.add(curNeighbor);
            } else {
                curNeighbor = new Node(neighbor.val);
                nodes.put(neighbor, curNeighbor);
                curNode.neighbors.add(curNeighbor);
                dfs(neighbor, nodes);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
