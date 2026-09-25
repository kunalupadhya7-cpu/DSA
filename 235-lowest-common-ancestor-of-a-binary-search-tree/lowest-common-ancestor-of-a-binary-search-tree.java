class Solution {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);

        return lca;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null)
            return false;

        if (node == p || node == q) {
            lca = node;
            return true;
        }


        // agar dono ek taraf he to node ca hosakta he lekin lca nahi 
        // ab ham left subtree me search karenge lca
        //similarly for else if 
        if (node.val > p.val && node.val > q.val) {
            return dfs(node.left, p, q);
         
        
        } else if (node.val < p.val && node.val < q.val) {
            return dfs(node.right, p, q);
        }

        // agar maan lo dono if and else if galat he matlab p and q alag alag side me he
        // matlab node hi lca he 

        lca=node;

        return true;

    }
}