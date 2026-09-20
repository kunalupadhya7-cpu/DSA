class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        
        f(root);
        return ans;
    }
    
    private void f(TreeNode node) {

        if (node == null) return;

         f(node.left);           // Left
         ans.add(node.val);      // Root
         f(node.right);          // Right
    }
}