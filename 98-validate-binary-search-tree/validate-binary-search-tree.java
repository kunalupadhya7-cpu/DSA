class Solution {

    public boolean isValidBST(TreeNode root) {
        return fun(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean fun(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max)
            return false;

        return fun(node.left, min, node.val)
            && fun(node.right, node.val, max);
    }
}