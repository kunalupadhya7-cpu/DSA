
class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If root becomes null, there is nothing left to search.
        if (root == null)
            return false;

        // Check if subRoot matches the tree starting at current root.
        if (check(root, subRoot))
            return true;

        // Search for subRoot in the left subtree.
        if (isSubtree(root.left, subRoot))
            return true;

        // Search for subRoot in the right subtree.
        if (isSubtree(root.right, subRoot))
            return true;

        // subRoot was not found anywhere.
        return false;
    }

    public boolean check(TreeNode a, TreeNode b) {

        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        if (a.val != b.val)
            return false;

        boolean l = check(a.left, b.left);
        boolean r = check(a.right, b.right);

        return l && r;
    }
}

