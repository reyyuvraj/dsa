package self.tree;

import java.util.ArrayList;

public class RightView {

    static void rightView(Node root, ArrayList<Integer> a, int current_Depth) {
        if (root == null) return;

        if (current_Depth == a.size()) a.add(root.key);
        rightView(root.right, a, current_Depth + 1);
        rightView(root.left, a, current_Depth + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        ArrayList<Integer> a = new ArrayList<>();
        rightView(root, a, 0);
        System.out.println(a);
    }
}
