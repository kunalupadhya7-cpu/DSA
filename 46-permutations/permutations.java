class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        f(nums, new ArrayList<>(), new HashSet<>());
        return ans;
    }

    public void f(int[] arr, ArrayList<Integer> list, Set<Integer> used) {

        // permutation complete ho gayi
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
        }

        // har index ko next position ke liye try karo
        for (int i = 0; i < arr.length; i++) {

            // agar index already use ho chuka hai, skip karo
            if (used.contains(i))
                continue;

            // current element ko permutation me pick karo
            list.add(arr[i]);
            used.add(i);

            // next position ke liye recursion
            f(arr, list, used);

            // backtrack: current choice undo karo
            list.remove(list.size() - 1);
            used.remove(i);
        }
    }
}