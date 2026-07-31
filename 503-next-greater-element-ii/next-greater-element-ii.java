class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 2; i >= 0; i--) {
            stack.push(nums[i]);
        }

        int [] ans = new int[n];

        for(int i =n-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i]=-1;
            }

            else{
                ans[i]=stack.peek();
            }

            stack.push(nums[i]);

        }

        return ans;

    }
}