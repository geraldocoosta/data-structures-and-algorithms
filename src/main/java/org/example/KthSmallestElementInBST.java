package org.example;

import java.util.Stack;

public class KthSmallestElementInBST {

    // recursive


    public int kthSmallest2(TreeNode root, int k) {
        int[] c = new int[]{0, 0};
        inOrder(root, k, c);
        return c[1];
    }

    public void inOrder(TreeNode root, int k, int[] c) {
        if (root == null || c[0] > k) return;
        inOrder(root.left, k, c);
        c[0]++;
        if (c[0] == k) c[1] = root.val;
        inOrder(root.right, k, c);
    }

    // iterative
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if (++count == k) return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }


}
