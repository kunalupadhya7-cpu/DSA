// follow the path sum template from pratush bhaya
class Solution {
    int maxCount = 0; // is the max nodes from root to leaf

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxCount;

    }

    public void dfs(TreeNode node, int count) {
        if (node == null)  return; // agar null he to return
           
        // null nahi he matlab kuch to he to count++;
        count++;
        // agar leaf he to ...kuch kuch karna he  acc to condition
        if (node.left == null && node.right == null) {
            maxCount = Math.max(maxCount, count);
            return;

        }

        // agar leaf nahi he to left aur right jaana he to find leaf

        dfs(node.left, count);
        dfs(node.right, count);
    }
}