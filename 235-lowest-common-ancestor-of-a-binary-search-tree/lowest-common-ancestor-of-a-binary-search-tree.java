// same as prev sol just return type is TreeNode
//for dry run that is easy
//for rec thinking in this case this is easy readable

class Solution {

   

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return dfs(root, p, q);

       
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) return null;
            

        if (node == p || node == q)  return node;
          
            
        

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

      return node;


    }
}