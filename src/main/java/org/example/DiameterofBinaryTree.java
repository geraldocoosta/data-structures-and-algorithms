package org.example;

public class DiameterofBinaryTree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(treeNode));
	}




	public static  int diameterOfBinaryTree(TreeNode root) {

		int[] ints = { 0 };
		maxDepth(root, ints);
		return ints[0];
	}

	private static int maxDepth(TreeNode root, int[] ints) {
		if (root == null) return 0;

		int left = maxDepth(root.left, ints);
		int right = maxDepth(root.right, ints);

		if (left + right > ints[0]) {
			ints[0] = left + right;
		}

		return Math.max(left, right) + 1;
	}
}
