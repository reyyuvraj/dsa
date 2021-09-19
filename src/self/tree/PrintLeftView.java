package self.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {

    int maxLevel = 0;

    void printLeft(Node root, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        printLeft(root.left, level + 1);
        printLeft(root.right, level + 1);
    }

    void printLeftView(Node root) {
        printLeft(root, 1);
    }

    static void left(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i=0;i<count;i++){
                Node a = q.poll();
                if (i==0)
                    System.out.print(a.key+" ");
                if (a.left!=null)
                    q.add(a.left);
                if (a.right!=null)
                    q.add(a.right);
            }
        }
    }

    public static void main(String[] args) {
        PrintLeftView pv = new PrintLeftView();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        pv.printLeftView(root);
        System.out.println();
        left(root);
    }
}