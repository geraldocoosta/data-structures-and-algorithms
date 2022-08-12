package org.example;

public class BinaryTreeMaxPathSum {

    int sum = Integer.MIN_VALUE;

    //Time complexity: O(N), where N is number of nodes, since we visit each node not more than 2 times.
    //
    //Space complexity: O(H), where H is a tree height, to keep the recursion stack.
    // In the average case of balanced tree, the tree height H=logN, in the worst case of skewed tree, H=N.

    // TODO: ESTUDAR
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int priceNewpath = node.val + leftGain + rightGain;

        // update max_sum if it's better to start a new path
        sum = Math.max(sum, priceNewpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return sum;
    }


}

/*
*
*
*
124. Binary Tree Maximum Path Sum
Hard

10924

576

Add to List

Share
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.



Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000



*
* */