
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int levelSize = q.size();

            List<Integer> temp = new ArrayList<>();

            while (levelSize != 0) {

                TreeNode t = q.poll();

                temp.add(t.val);

                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }

                levelSize--;
            }

            ans.add(temp);
        }

        Collections.reverse(ans);
        return ans;          // its just level order with ans in reverse order 

    }
}