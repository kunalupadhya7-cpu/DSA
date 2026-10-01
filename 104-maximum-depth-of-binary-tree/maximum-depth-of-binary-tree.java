
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftSubTreeHeight=maxDepth(root.left);
        int rightSubTreeHeight =maxDepth(root.right);

        return 1+ Math.max( leftSubTreeHeight,rightSubTreeHeight);
        
    }
}