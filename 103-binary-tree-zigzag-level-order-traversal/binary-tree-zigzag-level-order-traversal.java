class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);

        boolean reverse = false;

        while (!dq.isEmpty()) {

            int levelSize = dq.size();
            List<Integer> level = new ArrayList<>();

            while (levelSize != 0) {

                if (!reverse) {

                    TreeNode node = dq.pollFirst();

                    level.add(node.val);

                    if (node.left != null)
                        dq.offerLast(node.left);

                    if (node.right != null)
                        dq.offerLast(node.right);
                }

                else {

                    TreeNode node = dq.pollLast();

                    level.add(node.val);

                    if (node.right != null)
                        dq.offerFirst(node.right);

                    if (node.left != null)
                        dq.offerFirst(node.left);
                }

                levelSize--;
            }

            ans.add(level);
            reverse = !reverse;
        }

        return ans;
    }
}