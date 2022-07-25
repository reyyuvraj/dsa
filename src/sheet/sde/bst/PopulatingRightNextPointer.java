package sheet.sde.bst;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PopulatingRightNextPointer {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;

        TreeMap<Integer, ArrayList<Node>> map = new TreeMap<>();
        preorder(root, map, 0);

        for (Map.Entry<Integer, ArrayList<Node>> m : map.entrySet()) {
            ArrayList<Node> temp = m.getValue();
            int size = temp.size();
            temp.get(size - 1).next = null;

            for (int i = 1; i < size; i++) {
                temp.get(i-1).next = temp.get(i);
            }
        }

        return root;
    }

    private void preorder(Node node, TreeMap<Integer, ArrayList<Node>> map, int height) {
        if (node == null) return;

        map.computeIfAbsent(height, k -> new ArrayList<>());
        map.get(height).add(node);
        preorder(node.left, map, height + 1);
        preorder(node.right, map, height + 1);
    }
}
