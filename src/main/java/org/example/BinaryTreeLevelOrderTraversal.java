package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    // Time Complexity: O(N), where N is the number of nodes in the tree.
    //
    //Space Complexity: O(N) where N is the number of nodes in the tree.

    // TODO: Estudar
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        LinkedList<Integer> levelList = new LinkedList<>();

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.pollFirst();
            if (currentNode != null) {
                levelList.addLast(currentNode.val);

                if (currentNode.left != null) {
                    nodeQueue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodeQueue.addLast(currentNode.right);
                }
            } else {
                results.add(levelList);
                levelList = new LinkedList<>();
                if (!nodeQueue.isEmpty()) {
                    nodeQueue.addLast(null);
                }
            }
        }
        return results;
    }

}

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
* */