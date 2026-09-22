
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();

            while (levelSize != 0) {

                TreeNode node = q.poll();

                if (node == null) {
                    temp.add(null);
                    levelSize--;
                    continue;
                }

                temp.add(node.val);

                q.offer(node.left);
                q.offer(node.right);

                levelSize--;
            }

            // Every level must be a palindrome
            if (!isPalindrome(temp))
                return false;
        }

        return true;
    }

    public boolean isPalindrome(List<Integer> list) {

        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {

            if (!Objects.equals(list.get(left), list.get(right)))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
