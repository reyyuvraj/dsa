package self.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpiralTraversal {

    private static ArrayList<Integer> spiralTraversal(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();

        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();

            int arr[] = new int[size];

            for (int i = 0; i < arr.length; i++) {
                if (leftToRight) {
                    Node k = q.poll();
                    arr[i] = k.key;
                    if (k.left != null)
                        q.add(k.left);
                    if (k.right != null)
                        q.add(k.right);
                } else {
                    Node k = q.poll();
                    arr[size - i - 1] = k.key;
                    if (k.left != null)
                        q.add(k.left);
                    if (k.right != null)
                        q.add(k.right);
                }
            }
            for (int j : arr) {
                a.add(j);
            }
            leftToRight = !leftToRight;
        }
        return a;
    }

    private static List<List<Integer>> spiralTraversalList(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> a = new ArrayList<>();

        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();

            int arr[] = new int[size];
            List<Integer> ls = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                Node k = q.poll();
                if (leftToRight)
                    arr[i] = k.key;
                else
                    arr[size - i - 1] = k.key;
                if (k.left != null)
                    q.add(k.left);
                if (k.right != null)
                    q.add(k.right);
            }
            for (int i = 0; i < size; i++) {
                ls.add(arr[i]);
            }
            a.add(ls);
            leftToRight = !leftToRight;
        }
        return a;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(spiralTraversal(root));
        System.out.println(spiralTraversalList(root));
    }
}
