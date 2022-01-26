package self.tree;

public class CeilBST {

    private static int ceil(Node root, int val) {
        int result = -1;

        while (root != null) {
            if (root.key == val)
                return root.key;

            if (val > root.key)
                root = root.right;

            else {
                result = root.key;
                root = root.left;
            }
        }

        return result;
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
        System.out.println(ceil(root, 8));
    }
}
