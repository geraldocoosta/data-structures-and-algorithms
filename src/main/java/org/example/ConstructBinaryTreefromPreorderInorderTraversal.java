package org.example;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderInorderTraversal {

    public static void main(String[] args) {
        System.out.println(new Solution1().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    static class Solution1 {
        int preoderIndex;
        Map<Integer, Integer> inorderMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderMap = new HashMap<>();
            preoderIndex = 0;

            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return helper(preorder, 0, preorder.length - 1);
        }

        public TreeNode helper(int[] preorder, int left, int right) {
            if (left > right) return null;

            var root = new TreeNode(preorder[preoderIndex++]);

            root.left = helper(preorder, left, inorderMap.get(root.val) - 1);
            root.right = helper(preorder, inorderMap.get(root.val) + 1, right);

            return root;
        }
    }

    static class Solution2 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        // Preorder (Root, Left, Right) : 1 2 4 5 3
        // Inorder (Left, Root, Right) : 4 2 5 1 3

        public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inIndex = 0; // Index of current root in inorder
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    inIndex = i;
                }
            }
            root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
            root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
            return root;
        }
    }

}
