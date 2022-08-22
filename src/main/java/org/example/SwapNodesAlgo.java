package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNodesAlgo {


    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        Node root = new Node(1, 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!indexes.isEmpty()) {
            List<Integer> nodes = indexes.get(0);
            indexes.remove(0);

            Node temp = queue.poll();

            temp.left = nodes.get(0) == -1 ? null : new Node(nodes.get(0), temp.level + 1);
            temp.right = nodes.get(1) == -1 ? null : new Node(nodes.get(1), temp.level + 1);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        for (int i = 0; i < queries.size(); i++) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                if (curr.level % queries.get(i) == 0) {
                    Node templeft = curr.left;
                    curr.left = curr.right;
                    curr.right = templeft;
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            List<Integer> data = new ArrayList<>();
            inOrder(root, data);
            result.add(data);
        }

        return result;
    }

    public static void inOrder(Node root, List<Integer> data) {
        if (root == null) return;
        inOrder(root.left, data);
        data.add(root.data);
        inOrder(root.right, data);
    }

    static class Node {
        Node left;
        Node right;
        int data;
        int level;

        Node(int data, int level) {
            this.data = data;
            this.level = level;
            left = null;
            right = null;
        }
    }

}
