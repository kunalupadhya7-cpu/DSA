class Solution {
    public TreeNode invertTree(TreeNode root) {
        return f(root);
    }

    public TreeNode f(TreeNode node) {

        if (node == null) return null;

        // Swap left and right
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively invert both subtrees
        f(node.left);
        f(node.right);

        return node;
    }
}