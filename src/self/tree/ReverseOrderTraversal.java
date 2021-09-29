package self.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseOrderTraversal {

    static void reversePrint(Node root) {
        if (root == null)
            return;
        int height = height(root);
        for (int i = height; i >= 1; i--)
            printCurrentLevel(root, i);
    }

    static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + (Math.max(height(node.left), height(node.right)));
    }

    static ArrayList <Integer> reverseOrderTraversal(Node node){
        if (node==null)
            return null;

        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        q.add(node);

        while (!q.isEmpty()){
            node = q.poll();
            s.push(node);

            if (node.right!=null)
                q.add(node.right);

            if (node.left!=null)
                q.add(node.left);
        }
        while(!s.isEmpty()){
            arrayList.add(s.pop().key);
        }
        return arrayList;
     }

    static void printCurrentLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.key + " ");
        printCurrentLevel(node.left, level - 1);
        printCurrentLevel(node.right, level - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        reversePrint(root);
        System.out.println();
        System.out.println(reverseOrderTraversal(root));
    }
}