
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        q.offer(root);
        list.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();

            while (levelSize != 0) {
                TreeNode t = q.poll();

                if (t == null) {
                    levelSize--;
                    continue;
                }

                q.offer(t.left);
                list.add(t.left);
                q.offer(t.right);
                list.add(t.right);

                levelSize--;
            }

        }

        int i = 0;
        while (i < list.size() && list.get(i) != null) {
            i++;
        }

        while (i < list.size()) {
            if (list.get(i) != null)
                return false;
            i++;
        }

        return true;

    }

}