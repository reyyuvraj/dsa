package self.tree;

public class FloorBST {

    private static int floor(Node root, int val) {
        int floor = -1;

        while (root != null)
            if (root.key == val)
                return root.key;

        if (root.key > val)
            root = root.left;

        else {
            floor = root.key;
            root = root.right;
        }

        return floor;
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
        System.out.println(floor(root, 7));
    }
}
