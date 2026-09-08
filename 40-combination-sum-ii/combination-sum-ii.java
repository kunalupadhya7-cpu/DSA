class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
      

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
    
        
        f(idx+1, arr, sum, list, target);

        // Backtrack
        list.remove(list.size() - 1);
        sum -= arr[idx];

        // Not Take
         while (idx + 1 < arr.length &&
               arr[idx] == arr[idx + 1]) {
            idx++;
        }

        f(idx + 1, arr, sum, list, target);
    }
}