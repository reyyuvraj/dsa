package self.tree;

import java.util.List;

// flatten a binary to a linked list
// cannot create external list rearrange the current tree
public class FlattenTree {


    private static void preorder(Node node, List<Integer> list){

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        System.out.println();
    }
}
