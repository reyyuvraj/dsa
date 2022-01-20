package self.tree;
// count total number of nodes in a complete binary tree

public class CompleteTreeCount {

    private static int rightHeight(Node node) {
        if (node == null)
            return 0;

        int count = 0;

        while (node.right != null) {
            count++;
            node = node.right;
        }

        return count;
    }

    private static int leftHeight(Node node) {
        if (node == null)
            return 0;

        int count = 0;

        while (node.left != null) {
            count++;
            node = node.left;
        }

        return count;
    }

    private static int count(Node root) {
        if (root == null)
            return 0;

        int right = rightHeight(root);
        int left = leftHeight(root);

        if (left == right) return ((2 << left) - 1);

        return count(root.left) + count(root.right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        System.out.println(count(root));
    }
}
