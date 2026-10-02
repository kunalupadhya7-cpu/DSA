
class Solution {

    public boolean isCompleteTree(TreeNode root) {
        boolean nullSeen=false;

        Deque<TreeNode> q =new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode t =q.pop();

            if(t==null) nullSeen=true;

            else{
                if(nullSeen) return false;

                q.offer(t.left);
                q.offer(t.right);
            }

           
        }

        return true;
    }
}