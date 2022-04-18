package self.tree;

public class ConvertBSTToGreaterTree {

    int sum = 0;

    public Node convertBST(Node root) {
        if (root == null) return null;
        reverseInorder(root);
        return root;
    }

    public void reverseInorder(Node root) {
        if (root == null) return;

        reverseInorder(root.right);
        root.key += sum;
        sum = root.key;
        reverseInorder(root.left);
    }

    public void print(Node root) {
        if (root == null) return;

        print(root.right);
        System.out.print(root.key + " ");
        print(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(40);
        root.left.left = new Node(10);
        root.right.right = new Node(50);
        root.right.left = new Node(35);
        root.right.right.right = new Node(55);
        System.out.println("\n" + new ConvertBSTToGreaterTree().convertBST(root));
    }
}