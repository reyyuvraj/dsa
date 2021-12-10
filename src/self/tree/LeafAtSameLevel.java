package self.tree;

public class LeafAtSameLevel {

    static boolean check(Node root) {
        return leafLevel(root, height(root));
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static boolean leafLevel(Node root, int h) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            if (height(root) != h)
                return true;
        }
        return leafLevel(root.left, h) || leafLevel(root.right, h);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        System.out.println(check(root));
    }
}