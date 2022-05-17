package self.leetcode;

public class FindCorrespondingNode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode trg;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return null;
    }

    private void pre(TreeNode root, int target) {
        if (root == null) return;

        if (root.val == target) {
            trg = root;
            return;
        }
        pre(root.left, target);
        pre(root.right, target);
    }

    public static void main(String[] args) {

    }
}
