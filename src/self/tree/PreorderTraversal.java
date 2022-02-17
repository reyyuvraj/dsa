package self.tree;

import java.util.*;

public class PreorderTraversal {

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder(Node root, List<Integer> list) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();

        while (!s.isEmpty()) {
            Node a = s.pop();

            list.add(a.key);

            if (a.right != null)
                s.push(a.right);

            if (a.left != null)
                s.push(a.left);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        preorder(root);
    }
}