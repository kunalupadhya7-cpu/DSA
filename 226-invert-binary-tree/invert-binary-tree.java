class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null) return root;
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize=q.size();
            
            while(levelSize!=0){
                TreeNode node = q.poll();

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                
                TreeNode temp = node.left;
                node.left=node.right;
                node.right=temp;

                levelSize--;

            }
        }
        return root;
    }
}