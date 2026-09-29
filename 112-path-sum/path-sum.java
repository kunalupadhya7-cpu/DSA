class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return dfs(root, 0, targetSum);

    }

    public boolean dfs(TreeNode node, int sum ,int k){
        if(node==null) return false;
        sum+=node.val; 
        if(sum==k && node.left==null && node.right==null) return true; 

        if(dfs(node.left,sum,k)) return true;
        if(dfs(node.right,sum,k)) return true ;

        return false ; 

    }
} 
// The thought was very humanly intutive 
// just take a one root and 2 child and think how would u do just casully not coding mindset 
// apply the lojic for small tree it will work for big one 
