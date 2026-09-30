
class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return ans;
    }

    public void dfs(TreeNode node, int sum, int k) {

        // Base case
        if (node == null)
            return;

        sum += node.val;
        list.add(node.val);

       
        if (node.left == null && node.right == null) {
            if (sum == k) {
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }

        dfs(node.left, sum, k);
        dfs(node.right, sum, k);


        list.remove(list.size() - 1);
        return;
    }
}
