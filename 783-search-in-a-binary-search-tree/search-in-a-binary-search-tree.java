class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        return dfs(root, val);

    }

    public TreeNode dfs(TreeNode node, int val) {

        if (node == null)  return null;

        if (node.val == val)  return node;

        TreeNode l = dfs(node.left, val);
        if(l!=null) return l;

        TreeNode r = dfs(node.right, val);
        if(r!=null) return r;

        return null;


    }

} // same as prev sub just return type is TreeNode