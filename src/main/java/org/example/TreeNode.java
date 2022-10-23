package org.example;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(int[] ints) {
        if (ints.length == 0)
            return null;
        TreeNode root = new TreeNode(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            TreeNode node = root;
            while (true) {
                if (ints[i] < node.val) {
                    if (node.left == null) {
                        node.left = new TreeNode(ints[i]);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(ints[i]);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}