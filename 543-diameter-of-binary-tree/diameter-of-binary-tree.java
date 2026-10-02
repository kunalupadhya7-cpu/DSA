

class Solution {
    int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
        
    }

    public int height(TreeNode node){ // height is ntg but no of nodes in path
        if(node==null) return 0;
        
        int l=height(node.left); // l =heightOfLeftSuubTree
        int r= height(node.right); 

        //
        int d=(l+r+1)-1; // d =diameter of curr node // l==no of nodes in left ,,r means no of nodes in right// +1 means the curr node // and no of nodes in path - 1 is the no of edges
        maxDiameter=Math.max(maxDiameter,d);
        //

        return 1+Math.max(l,r);
    }
}