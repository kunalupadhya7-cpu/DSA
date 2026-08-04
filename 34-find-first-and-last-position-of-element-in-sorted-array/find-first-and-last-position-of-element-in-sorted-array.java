class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int low = 0;
        int high = nums.length-1;
        int minIndex = -1;
        int maxIndex = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {

                minIndex = mid;
                high = mid - 1;

            } else if (nums[mid] > target) {

                high = mid - 1;
            }

            else {

                low = mid + 1;
            }

        }

        low = 0;
        high = nums.length-1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {

                maxIndex = mid;
                low = mid + 1;

            } else if (nums[mid] > target) {

                high = mid - 1;
            }

            else {

                low = mid + 1;
            }

        }

        return new int[] { minIndex, maxIndex };

    }
}