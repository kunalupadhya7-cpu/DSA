class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int maxIdx = 0;

        for (int i = 1; i < n; i++) { //it give me the first idx of maxElement
            if (max < nums[i]) {
                max = nums[i]; // why to find this because i know no element is greater than it so 
                maxIdx = i; //  the ans id -1 for this 
            }

        }

        Deque<Integer> st = new ArrayDeque<>();
        st.push(max);

        int ans[] = new int[n];
        ans[maxIdx] = -1;

        int i = maxIdx - 1;

        if (i < 0){
            i = n - 1;
        }

        while (i != maxIdx) {

            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            }

            else {
                ans[i] = st.peek();
            }

            st.push(nums[i]);

            i--;

            if (i < 0){
                i = n - 1;
            }

        }
        return ans;

    }
}