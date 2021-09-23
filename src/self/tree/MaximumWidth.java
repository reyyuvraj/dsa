package self.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

    static int width(Node root){
        if (root==null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int res=0;
        while (!q.isEmpty()){
            int count  = q.size();
            res=Math.max(res,count);
            for (int i=0; i<count; i++){
                Node a = q.poll();
                if (a.left!=null)
                    q.add(a.left);
                if (a.right!=null)
                    q.add(a.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PrintLeftView pv = new PrintLeftView();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(width(root));
    }
}