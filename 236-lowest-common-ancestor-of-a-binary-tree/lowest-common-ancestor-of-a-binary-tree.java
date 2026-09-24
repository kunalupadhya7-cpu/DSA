class Solution {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        f(root, p, q);
        return lca;
    }

    public boolean f(TreeNode node, TreeNode p, TreeNode q) {

        // Reached the end, so p/q was not found
        if (node == null)
            return false;

        // Found p or q
        if (node == p || node == q) {
            lca = node;
            return true;
        }

        // Check if p/q is found in the left subtree
        boolean foundLeft = f(node.left, p, q);

        // Check if p/q is found in the right subtree
        boolean foundRight = f(node.right, p, q);

        // If both sides found p/q, current node is their LCA
        if (foundLeft && foundRight)
            lca = node;

        // Tell the parent whether p or q was found in this subtree
        return foundLeft || foundRight;
    }
} 
// dam i found it on own 