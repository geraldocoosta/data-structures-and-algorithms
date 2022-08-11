package org.example;

public class BinaryTree {

    public static void main(String[] args) {
        Node node = new Node();
        node.data = 5;
        node.left = new Node();
        node.left.data = 2;
        node.right = new Node();
        node.right.data = 3;
        System.out.println(height(node));
        System.out.println(lca(node, 2, 3).data);
        decode("101", node);
    }
    public static int height(Node root) {
        if (root == null)
            return -1;

        int lDepth = height(root.left);
        int rDepth = height(root.right);

        /* use the larger one */
        if (lDepth > rDepth)
            return (lDepth + 1);
        else
            return (rDepth + 1);
    }

    public static Node lca(Node root, int v1, int v2) {
        //Decide if you have to call rekursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        //Else solution already found
        return root;
    }

    static void decode(String s, Node root) {
        Node aux = root;
        String decoded = "";

        for (int i = 0; i < s.length(); i++) {
            char caracter = s.charAt(i);
            aux = caracter == '1' ? aux.right : aux.left;
            if (aux.left == null && aux.right == null) {
                decoded = decoded + aux.data;
                aux = root;
            }
        }

        System.out.println(decoded);

    }
    
    static class Node {
        int data;
        Node left;
        Node right;
    }
}
