class Solution {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int num) {
        if (node == null)
            return;
        num = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            ans += num;

        }

        dfs(node.left, num);
        dfs(node.right, num);

    }
}