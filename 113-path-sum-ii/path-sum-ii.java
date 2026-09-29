
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode node, int sum, int k, List<Integer> list) {

        // Base case
        if (node == null)
            return;

        sum += node.val;
        list.add(node.val);

        // Check valid root-to-leaf path
        if (sum == k && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(list));
        }

        dfs(node.left, sum, k, list);
        dfs(node.right, sum, k, list);

        // Backtrack
        list.remove(list.size() - 1);
    }
}
