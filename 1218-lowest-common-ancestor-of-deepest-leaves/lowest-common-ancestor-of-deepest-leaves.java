class Solution {

    TreeNode lca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int h = height(root);

        fun(root, 1, h);

        return lca;
    }

    public boolean fun(TreeNode node, int d, int h) {
        if (node == null)
            return false;

        if (d == h) {
            lca = node;
            return true;
        }

        boolean l = fun(node.left, d + 1, h);
        boolean r = fun(node.right, d + 1, h);

        if (l && r)
            lca = node;

        return l||r ;
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;

        int l = height(node.left);
        int r = height(node.right);

        return 1 + Math.max(l, r);
    }
}