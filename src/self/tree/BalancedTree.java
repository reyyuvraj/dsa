package self.tree;

public class BalancedTree {

    static boolean balanced(Node root){
        if (root==null)
            return true;
        int d = Math.abs(height(root.left)-height(root.right));
        if (d<=1)
            return balanced(root.left) && balanced(root.right);
        return false;
    }

    static int height(Node root){
        if (root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(balanced(root));
    }
}
