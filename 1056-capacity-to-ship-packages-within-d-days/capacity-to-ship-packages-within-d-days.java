class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int low = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            low = Math.max(low, weights[i]);
        }

        int high = sum;
        int ans = -1;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (fun(weights, days, guess) == true) {
                ans = guess;
                high = guess - 1;
            } 
            else {
                low = guess + 1;
            }
        }

        return ans;
    }

    public boolean fun(int[] weights, int days, int guess) {

        int weightPerDay = 0;
        int reqDays = 1;

        for (int i = 0; i < weights.length; i++) {

            if (weightPerDay + weights[i] <= guess) {
                weightPerDay += weights[i];
            } 
            else {
                reqDays++;
                weightPerDay = weights[i];
            }
        }

        if (reqDays > days) {
            return false;
        } 
        else {
            return true;
        }
    }
}