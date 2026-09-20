class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans= new ArrayList<>();

        postorder(root, ans);
        return ans;
        
    }
    
    private void postorder(TreeNode node, List<Integer> ans) {

        if (node == null) return;
        
        postorder(node.left,ans);      // Left          
        postorder(node.right,ans);     // Right
        ans.add(node.val);             //Root

    }
}