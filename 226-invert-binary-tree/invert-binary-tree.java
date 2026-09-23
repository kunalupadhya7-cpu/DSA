class Solution {
    public TreeNode invertTree(TreeNode root) {
         f(root);
         return root;
    }

    public void f(TreeNode node) {

        if (node == null) return ;

        // Swap left and right
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively invert both subtrees
        f(node.left);
        f(node.right);

    }
}