package org.example;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		int k = 1;
		System.out.println(kthSmallest(root, k));
	}

	// Time: O(n)
	// Space: O(n)
	public static int kthSmallest(TreeNode root, int k) {

		List<Integer> nums = inorder(root, new ArrayList<>());
		return nums.get(k - 1);
	}

	private static List<Integer> inorder(TreeNode root, List<Integer> arr) {

		if (root == null) {
			return arr;
		}
		inorder(root.left, arr);
		arr.add(root.val);
		inorder(root.right, arr);
		return arr;
	}

}

/*
*Kth Smallest Element in a BST
* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104


Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
*
* */