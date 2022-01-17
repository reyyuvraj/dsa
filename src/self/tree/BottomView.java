package self.tree;

import java.util.*;

public class BottomView {

    static class Tuple{
        Node node;
        int x;
        Tuple(Node node, int x){
            this.node = node;
            this.x = x;
        }
    }

    private static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> a = new ArrayList<>();
        if (root==null) return a;

        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        q.add(new Tuple(root, 0));

        while(!q.isEmpty()){
            Tuple tp = q.poll();
            Node tp_node = tp.node;
            int x = tp.x;

            if (!tm.containsKey(x) && isLeaf(tp_node)) tm.put(x, tp_node.key);

            if (tp_node.left!=null) q.add(new Tuple(tp_node.left, x-1));

            if (tp_node.right!=null) q.add(new Tuple(tp_node.right, x+1));
        }

        for (Map.Entry<Integer, Integer> y : tm.entrySet())
            a.add(y.getValue());

        return a;
    }

    private static boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(bottomView(root));
    }
}
