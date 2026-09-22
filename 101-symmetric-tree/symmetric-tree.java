class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root==null) return true;
        
        return f(root.left,root.right);
        
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

       
        boolean l = f(a.left, b.right);
        boolean r = f(a.right, b.left);

        return l && r;
    }
}