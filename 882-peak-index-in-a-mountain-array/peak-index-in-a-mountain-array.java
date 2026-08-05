class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int peek = -1;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (arr[guess] > arr[guess + 1]) {
                peek = guess;
                high = guess - 1;

            }

            else {
                low = guess + 1;
            }

        }

        return peek;

    }
}