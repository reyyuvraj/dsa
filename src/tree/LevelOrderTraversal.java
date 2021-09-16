package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static void levelTraversal(Node root){
        if (root==null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node c = q.poll();
            System.out.print(c.key+" ");
            if (c.left!=null)
                q.add(c.left);
            if (c.right!=null)
                q.add(c.right);
        }
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        levelTraversal(root);
    }
}
