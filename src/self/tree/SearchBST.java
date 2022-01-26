package self.tree;

public class SearchBST {

    private static Node search(Node root, int val){
        while (root!=null && root.key!=val){
            root = (root.key>val)?root.left:root.right;
        }
        return root;
    }

    public static void main(String[] args){
        Node root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(40);
        root.left.left = new Node(10);
        root.right.right = new Node(50);
        System.out.println(search(root, 50));
    }
}
