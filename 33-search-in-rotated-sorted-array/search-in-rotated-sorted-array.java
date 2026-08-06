class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int minIdx = 0;
        int maxIdx = n - 1;

        while (low <= high) {//while

            int guess = (low + high) / 2;

            if (nums[guess] > nums[n - 1]) {
                low = guess + 1;
            }

            else {
                minIdx = guess;
                high = guess - 1;
            }

        } // while

        if (minIdx == 0) {
            maxIdx = n - 1;

        }

        else {
            maxIdx = minIdx - 1;
        }

        if (target >= nums[minIdx] && target <= nums[n - 1]) {

            low = minIdx;
            high = n - 1;

        }

        else if (target >= nums[0] && target <= nums[maxIdx]) {
            low = 0;
            high = maxIdx;

        }

        int ans = -1;

        while (low <= high) {
            int guess = (low + high) / 2;

            if (nums[guess] == target) {
                return guess;

            }

            else if (nums[guess] > target) {
                high = guess - 1;

            }

            else {
                low = guess + 1;
            }
        }

        return ans;

    }
}