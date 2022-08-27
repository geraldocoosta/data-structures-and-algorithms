package org.example;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumDepthBT {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        int max = 1;

        // uma stack para armazenar os nós
        Deque<TreeNode> nodes = new LinkedList<>();
        // outra para armazenar os niveis
        Deque<Integer> depths = new LinkedList<>();

        // coloco o primeiro nivel
        nodes.push(root);
        // o primeiro nivel é representado pelo 1
        depths.push(1);

        while (!nodes.isEmpty()) {
            // pego o nó e o nível
            TreeNode curr = nodes.pop();
            int depth = depths.pop();

            // se o nó for folha, atualizo o max
            if (curr.left == null && curr.right == null) {
                max = Math.max(max, depth);
            }

            // se o nó tiver filho esquerdo, coloco na stack
            if (curr.right != null) {
                nodes.push(curr.right);
                // o nivel do filho vai ser nivel atual + 1
                depths.push(depth + 1);
            }
            // se o nó tiver filho direito, coloco na stack
            if (curr.left != null) {
                nodes.push(curr.left);
                // o nivel do filho vai ser nivel atual + 1
                depths.push(depth + 1);
            }
        }

        return max;

    }

}


