
class Solution {
    boolean ans =true; // sabse pehle ans ko true man ke chalo 

    public boolean isBalanced(TreeNode root) {

        height(root);
        return ans;
        
    }

    public int height(TreeNode node){
        if(node==null) return 0;

        int l= height(node.left); // l=left sub tree height
        int r =height(node.right); // r== right sub tree height

        if(Math.abs(l-r)>1)  ans =false; // agar kahi gadbad he to false hojayega // 
                                         // aur agar nahi he to true to he hi pehle se 

        return 1+Math.max(l,r); 
    }
} // same template as Leetcode 104 ,111