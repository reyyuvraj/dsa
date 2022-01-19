package self.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

    static class Width
    {
        Node node;
        int index;
        Width(Node node, int index)
        {
            this.node = node;
            this.index = index;
        }
    }

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

    public static int maximumWidth(Node root)
    {
        if (root==null)
            return 0;

        Queue<Width> q = new LinkedList<>();

        q.add(new Width(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;

            Width temp = q.poll();
            Node temp_node = temp.node;
            int index = temp.index;

            if (temp_node.left != null)
                q.add(new Width(temp_node, (2*index+1)-index));

            if (temp_node.right != null)
                q.add(new Width(temp_node, (2*index+2)-index));
        }
        return q.peek().index;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.left.left = new Node(60);
        System.out.println(width(root));
        System.out.println(maximumWidth(root));
    }
}