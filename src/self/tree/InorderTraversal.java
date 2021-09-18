package self.tree;

class Node{
    int key;
    Node left;
    Node right;
    Node(int k){
        key = k;
    }
}
public class InorderTraversal {
    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        inorder(root);
    }
}
