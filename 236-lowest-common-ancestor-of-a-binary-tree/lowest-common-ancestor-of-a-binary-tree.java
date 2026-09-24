class Solution {
    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        f(root, p, q);
        return lca;
    }

    public boolean f(TreeNode node, TreeNode p, TreeNode q) {
        boolean l = false;
        boolean r = false;

        if (node == null)
            return false;

        if (f(node.left, p, q))
            l = true;

        if (f(node.right, p, q))
            r = true;

        if (node == p || node == q) {
            lca = node;
            return true;
        }

        if (l && r)
            lca = node;

        return l || r;
    }
}