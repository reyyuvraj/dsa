package sheet.sde.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class PathToGivenNode {

    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(A, B, res);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) r[i] = res.get(i);

        return r;
    }

    private boolean dfs(TreeNode root, int value, ArrayList<Integer> res) {
        if (root == null) return false;

        res.add(root.val);
        if (root.val == value) return true;

        if (dfs(root.left, value, res) || dfs(root.right, value, res))
            return true;

        res.remove(res.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(50);
        System.out.println(Arrays.toString(new PathToGivenNode().solve(root, 50)));
    }
}
