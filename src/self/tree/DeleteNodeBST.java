package self.tree;

public class DeleteNodeBST {

    private static Node delete(Node root, int val) {

        if (root == null)
            return null;

        if (root.key == val) {
            return helper(root);
        }
        Node changed = root;

        while (root != null) {
            if (root.key > val) {
                if (root.left != null && root.left.key == val) {
                    root.left = helper(root.left);
                    break;
                } else root = root.left;
            }

            if (root.key < val) {
                if (root.right != null && root.right.key == val) {
                    root.right = helper(root.right);
                } else root = root.right;
            }
        }
        return changed;
    }

    private static Node helper(Node root) {
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;
        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    private static Node findLastRight(Node root) {
        if (root.right == null)
            return root;
        return findLastRight(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(13);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.right = new Node(9);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(4);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        System.out.println(delete(root, 5));
    }
}
