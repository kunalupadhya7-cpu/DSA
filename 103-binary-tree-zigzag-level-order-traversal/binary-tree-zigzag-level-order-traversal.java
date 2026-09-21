class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        // Initially reverse is false because level 0 is even,
        // so we add it from left to right.
        boolean reverse = false;

        while (!q.isEmpty()) {

            // Number of nodes in the current level
            int levelSize = q.size();

            List<Integer> temp = new ArrayList<>();

            while (levelSize != 0) {

                TreeNode t = q.poll();

                // Add the current node
                temp.add(t.val);

                // Add left child for the next level
                if (t.left != null) {
                    q.offer(t.left);
                }

                // Add right child for the next level
                if (t.right != null) {
                    q.offer(t.right);
                }

                levelSize--;
            }

            // If reverse is false, add from left to right
            if (reverse == false) {
                ans.add(temp);
            }

            // If reverse is true, add from right to left
            else {
                Collections.reverse(temp);
                ans.add(temp);
            }

            // Toggle reverse for the next level
            reverse = !reverse;
        }

        return ans;
    }
}