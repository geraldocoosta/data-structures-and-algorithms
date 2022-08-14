package org.example;

public class ValidateBinarySearchTree {


    public static void main(String[] args) {
        new TreeNode(5).left = new TreeNode(2);
        new TreeNode(5).right = new TreeNode(3);
        System.out.println(isValidBST(new TreeNode(5)));
    }

    // Time complexity : O(N) since we visit each node exactly once.
    // Space complexity : O(N) since we keep up to the entire tree.

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if (low == null) {
            low = Integer.MIN_VALUE;
        }

        if (high == null) {
            high = Integer.MAX_VALUE;
        }

        if (root.val <= low || root.val >= high) {
            return false;
        }

        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/*

Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/