class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int max = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            if (bloomDay[i] > max) {
                max = bloomDay[i];
            }

        }

        int low = 1; // min no days to bloom is 1
        int high = max; // max no of days req to bloom i.e is the max of arr
        // this our range [1,max] where we are guessing and appling bs <<<IMP>> 
        int ans = -1;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (fun(bloomDay, m, k, guess) == true) {
                ans = guess;
                high = guess - 1;
            } else {
                low = guess + 1;
            }

        }
        return ans;

    }

    public boolean fun(int[] bloomDay, int m, int k, int guess) {
        int[] arr = bloomDay.clone();

        int count = 0;
        int bouquetsMade = 0;

        for (int i = 0; i < arr.length; i++) {
            
            if (guess >= arr[i]) {
                count++; // this is the consecutive count of flowers

                if (count == k) {
                    bouquetsMade++;
                    count = 0;
                }

            }

            else {
                count = 0;
            }

        }

        if (bouquetsMade < m) {
            return false;
        }

        else {
            return true;
        }

    }
}