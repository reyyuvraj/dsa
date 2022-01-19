package self.tree;

public class SymmetricTree {

    static boolean symmetricBinaryTree(Node root){
        return root==null || symmetricCheck(root.left, root.right);
    }

    static boolean symmetricCheck(Node left, Node right){
        if (left==null || right==null)
            return left==right;

        if (left.key != right.key) return false;

        return symmetricCheck(left.left, right.right)
                && symmetricCheck(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(symmetricBinaryTree(root));
    }
}
