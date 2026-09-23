class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) return true;
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode t = q.poll();

            if (t.val == subRoot.val && check(t, subRoot))
                return true;

            if (t.left != null)
                q.offer(t.left);

            if (t.right != null)
                q.offer(t.right);
        }

        return false;
    }

    public boolean check(TreeNode a, TreeNode b) {

        // Both are null → same
        if (a == null && b == null)
            return true;

        // One is null → different
        if (a == null || b == null)
            return false;

        // Values different → different
        if (a.val != b.val)
            return false;

        boolean l = check(a.left, b.left);
        boolean r = check(a.right, b.right);

        return l && r;
    }
}