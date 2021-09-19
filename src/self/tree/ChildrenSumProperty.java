package self.tree;

public class ChildrenSumProperty {

    static boolean sum(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int s = 0;
        if (root.left != null) {
            s += root.left.key;
        }
        if (root.right != null) {
            s += root.right.key;
        }
        return root.key == s && sum(root.left) && sum(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(sum(root));
    }
}
