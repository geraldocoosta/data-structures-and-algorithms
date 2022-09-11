package org.example;

public class BalancedHeightBinaryTree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(2);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(3);
		treeNode.left.left.left = new TreeNode(4);
		treeNode.left.left.right = new TreeNode(4);

		System.out.println(isBalanced(treeNode));
	}

	public static boolean isBalanced(TreeNode root) {

		return dfsHeight(root) != -1;
	}

	public static int dfsHeight(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int resultLeft = dfsHeight(root.left);
		if (resultLeft == -1) {
			return -1;
		}

		int resultRight = dfsHeight(root.right);
		if (resultRight == -1) {
			return -1;
		}

		if (Math.abs(resultLeft - resultRight) > 1) {
			return -1;
		}

		return Math.max(resultLeft, resultRight) + 1;

	}
}
