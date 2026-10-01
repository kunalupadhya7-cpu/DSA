
class Solution {
    int minCount=Integer.MAX_VALUE; // imp step 
    public int minDepth(TreeNode root) {
        if(root==null) return 0; // for one failed case 52/53
        dfs(root,0);
        return minCount;

    }

    
    public void dfs(TreeNode node, int count) {
        if (node == null)  return; 
           
        
        count++;
        
        if (node.left == null && node.right == null) {
            minCount = Math.min(minCount, count);
            return;

        }

        
        dfs(node.left, count);
        dfs(node.right, count);
    }

}