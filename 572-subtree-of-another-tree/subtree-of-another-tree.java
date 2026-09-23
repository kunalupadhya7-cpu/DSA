class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            while (levelSize != 0) {

                TreeNode t = q.poll();

                if (check(t, subRoot))
                    return true;

                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);

                levelSize--;

            }

        }

        return false;


    }

    

    public boolean check(TreeNode a,TreeNode b){
       if(a== null && b==null) return true;
       if(a==null || b==null) return false;
       if(a.val!=b.val) return false;

        boolean l= check(a.left,b.left);
        boolean r= check(a.right,b.right);

        return l && r;

    }
}