class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        f(0, candidates, 0, new ArrayList<>(), target);
        return ans;
    }

    public void f(int idx, int[] arr, int sum,
                  ArrayList<Integer> list, int target) {

        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target || idx == arr.length) {
            return;
        }

        // Take
        list.add(arr[idx]);
        sum += arr[idx];

        f(idx, arr, sum, list, target);

        // Backtrack
        list.remove(list.size() - 1);
        sum -= arr[idx];

        // Not Take
        f(idx + 1, arr, sum, list, target);
    }
}