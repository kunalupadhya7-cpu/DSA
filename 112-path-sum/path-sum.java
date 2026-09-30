class Solution {
    boolean res=false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

         dfs(root, 0, targetSum);
         return res;

    }

    public void dfs(TreeNode node, int sum ,int k){
        if(node==null) return ;
        sum+=node.val; 
        if(sum==k && node.left==null && node.right==null) {
            res=true;
            return;
        } 

        dfs(node.left,sum,k);
        dfs(node.right,sum,k);

         

    }
} 

