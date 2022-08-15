package org.example;

public class DiameterOfBinaryTree {

    private int diameter;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    // Depth-first Search
    // Time complexity: O(N). This is because in our recursion function longestPath, we only enter and exit from each node once.
    // We know this because each node is entered from its parent, and in a tree, nodes only have one parent.
    //
    // Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS,
    // which relates to the height of the tree.
    // In the worst case, the tree is skewed so the height of the tree is O(N). If the tree is balanced, it'd be O(logN).
    private int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // recursively find the longest path in
        // both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest one between leftPath and rightPath;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }
}

/*

Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100


*/