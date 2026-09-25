class Solution {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Start DFS from the root
        dfs(root, p, q);

        return lca;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {

        // If node is null, neither p nor q is found
        if (node == null)
            return false;

        // If current node is either p or q, we found one target node
        if (node == p || node == q) {
            lca = node;
            return true;
        }

        // If current node is greater than both p and q,
        // both nodes are present in the left subtree
        if (node.val > p.val && node.val > q.val) {
            return dfs(node.left, p, q);

        // If current node is smaller than both p and q,
        // both nodes are present in the right subtree
        } else if (node.val < p.val && node.val < q.val) {
            return dfs(node.right, p, q);
        }

        // Search both left and right subtrees
        boolean leftFound = dfs(node.left, p, q);
        boolean rightFound = dfs(node.right, p, q);

        // If one target is found in each subtree,
        // current node is their Lowest Common Ancestor
        if (leftFound && rightFound) {
            lca = node;
            return true;
        }

        // Return true if either p or q is found
        return leftFound || rightFound;
    }
}

