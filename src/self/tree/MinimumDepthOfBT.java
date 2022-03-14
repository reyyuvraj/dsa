package self.tree;

public class MinimumDepthOfBT {

    int min = Integer.MAX_VALUE;

    public int minDepth(Node root) {
        if (root == null)
            return 0;
        minDepth(root, 0);
        return min;
    }

    public void minDepth(Node root, int count) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            min = Math.min(min, count);
            return;
        }
        minDepth(root.left, count);
        minDepth(root.right, count);
    }

    public boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}
