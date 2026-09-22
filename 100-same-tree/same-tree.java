class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return f(p, q);
    }

    public boolean f(TreeNode a, TreeNode b) {

        // Both null → same
        if (a == null && b == null)
            return true;

        // One null → different
        if (a == null || b == null)
            return false;

        // Values different → different
        if (a.val != b.val)
            return false;

        // Check left and right subtrees
        boolean l = f(a.left, b.left);
        boolean r = f(a.right, b.right);

        return l && r;
    }
}