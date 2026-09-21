class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // Final answer: each inner list represents one level of the tree
        List<List<Integer>> ans = new ArrayList<>();

        // If tree is empty, return empty answer
        if (root == null) return ans;

        // Queue is used for Breadth First Search (BFS)
        Queue<TreeNode> q = new ArrayDeque<>();

        // Start BFS by adding the root node
        q.offer(root);

        // Continue until all nodes are processed
        while (!q.isEmpty()) {

            // Number of nodes present at the current level
            int levelSize = q.size();

            // Stores values of nodes of the current level
            List<Integer> temp = new ArrayList<>();

            // Process all nodes of the current level
            while (levelSize != 0) {

                // Remove the front node from the queue
                TreeNode t = q.poll();

                // Add current node's value to current level
                temp.add(t.val);

                // Add left child to queue for the next level
                if (t.left != null) {
                    q.offer(t.left);
                }

                // Add right child to queue for the next level
                if (t.right != null) {
                    q.offer(t.right);
                }

                // One node of the current level is processed
                levelSize--;
            }

            // Add the complete current level to the answer
            ans.add(temp);
        }

        return ans;
    }
}