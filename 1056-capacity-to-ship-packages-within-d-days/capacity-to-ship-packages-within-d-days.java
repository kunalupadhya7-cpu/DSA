
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
        int reqDays=1;
        int sum=0;

        for(int i =0 ;i<weights.length;i++){

            if(sum+weights[i]>guess){
                reqDays++;
                sum=weights[i];
            }

            else{
                sum+=weights[i];
            }
        }

       return reqDays<=days;
    }

    
}