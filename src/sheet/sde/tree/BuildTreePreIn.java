package sheet.sde.tree;

import java.util.HashMap;

public class BuildTreePreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < len; i++)
            hm.put(inorder[i], i);

        return buildTreeWithPreIn(preorder, 0, len - 1,
                inorder, 0, len - 1, hm);
    }

    private TreeNode buildTreeWithPreIn(int[] preorder, int preStart, int preEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        HashMap<Integer, Integer> hm) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = hm.get(preorder[preStart]);
        int numLeft = inRoot - inStart;

        root.left = buildTreeWithPreIn(preorder, preStart + 1, preStart + numLeft,
                inorder, inStart, inRoot - 1, hm);
        root.right = buildTreeWithPreIn(preorder, preStart + numLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, hm);

        return root;
    }
}
