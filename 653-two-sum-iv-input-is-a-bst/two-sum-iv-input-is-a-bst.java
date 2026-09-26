class Solution {

    List<Integer> list = new ArrayList<>(); 

    public boolean findTarget(TreeNode root, int k) {

        inorder(root); // makes list as sorted array
        
        // from here its normal 2 pointer 2 sum approch

        int l=0;     
        int r=list.size()-1;

        while(l<r){

            int sum= list.get(l)+list.get(r);

             if(sum==k) return true;

             else if(sum>k) r--;
          
             else l++;
             
             
          
        }
        

        return false;
        

        
     
    }

    public void inorder(TreeNode node){

        if(node==null) return ;

        inorder(node.left);
        list.add(node.val);
        inorder(node.right);

    }
}