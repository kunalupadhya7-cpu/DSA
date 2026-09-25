// this is og code time O(log(N)) and is simliar to binary search


class Solution {
    TreeNode ans =null;
    public TreeNode searchBST(TreeNode root, int val) {
        dfs (root,val);
        return ans;
        
    }

    public void dfs(TreeNode node,int val){
        
        if(node==null) return ; // similar to while(left<=right)

        if(node.val==val){ // to a[mid]== val
            ans=node;
            return ;
        }
        if(node.val<val){         //l=m+1;
            dfs(node.right,val);
        } 
        else{
            dfs(node.left,val); //r=m-1;
        }
    }
} 