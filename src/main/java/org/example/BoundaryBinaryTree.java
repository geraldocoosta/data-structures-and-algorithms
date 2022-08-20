package org.example;

import java.util.ArrayList;
import java.util.List;

public class BoundaryBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(4);
        treeNode.right = treeNode1;
        System.out.println(boundaryOfBinaryTree(treeNode));
    }


    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            getBounds(root.left, res, true, false);
            getBounds(root.right, res, false, true);
        }
        return res;
    }

    private static void getBounds(TreeNode node, List<Integer> res, boolean lb, boolean rb) {
        if (node == null) {
            return;
        }
        if (lb) {
            res.add(node.val);
        }
        if (!lb && !rb && node.left == null && node.right == null) {
            res.add(node.val);
        }
        getBounds(node.left, res, lb, rb && node.right == null);
        getBounds(node.right, res, lb && node.left == null, rb);
        if (rb) {
            res.add(node.val);
        }
    }
}
