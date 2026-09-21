class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int count = 0;

        while (!q.isEmpty()) {

            // Number of nodes in current level
            int levelSize = q.size();

            List<Integer> temp = new ArrayList<>();

            while (levelSize != 0) {

                TreeNode t = q.poll();

                // Add current node
                temp.add(t.val);

                // Add children for next level
                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }

                levelSize--;
            }

            // Even level -> left to right
            if (count % 2 == 0) {
                ans.add(temp);
            }

            // Odd level -> right to left
            else {
                Collections.reverse(temp);
                ans.add(temp);
            }

            count++;
        }

        return ans;
    }
}