class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
     
     int  l=height(root.left);
     int  r=height(root.right);

      if(Math.abs(l-r)>1) return false ;

        return isBalanced(root.left) && isBalanced(root.right) ;
    }

    public int  height(TreeNode node){
        if(node==null) return 0;
        int l = height(node.left);
        int r=height(node.right);

        return 1+Math.max(l,r);

    }

    
}