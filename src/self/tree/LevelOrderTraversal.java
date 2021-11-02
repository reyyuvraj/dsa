package self.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static ArrayList<Integer> levelTraversal(Node node) {
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node c = q.poll();
            a.add(c.key);
            if (c.left != null)
                q.add(c.left);
            if (c.right != null)
                q.add(c.right);
        }
        return a;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.print(levelTraversal(root));
    }
}
