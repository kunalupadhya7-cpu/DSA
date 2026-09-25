class Solution {
    TreeNode ans = null;

    public TreeNode searchBST(TreeNode root, int val) {

        dfs(root, val);
        return ans;

    }
    //how to think rec fun 
    //task ->find node
    //start with a small tree say one root and 2 child
    //now think what will happen here in this one case only  //// rest rec will def handel
    // in the entire code the boolean fun role is to ask the node is it the req node if yes we store that node and ret true...
    // if not then we return false 
    // true---> iam the req node
    // false---> no iam not that req node

    public boolean dfs(TreeNode node, int val) {
        
        // firstly if the root is null 100 per we will not find node with val ==val ,,so return false
        if (node == null) return false; 

        // if the root val == val then we --> return true ,,means we found the req node no need further rec    
        if (node.val == val) {
            ans = node;
            return true;
        }

        //if not the root is the req node then 

        //think this line as i am asking the left node  "are u req node",  if he say "yes" then ---> return true , no need to go right"
        if (dfs(node.left, val)) return true;
        
        // if not left ask right node "are u req node" if yes -----> return true 
        if (dfs(node.right, val)) return true;


        //if neither of left nor right nodes is req node then 
        // i not found it 
        // so return false

        return false;

       

    }

}