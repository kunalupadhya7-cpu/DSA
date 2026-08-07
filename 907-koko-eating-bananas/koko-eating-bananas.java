class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        Arrays.sort(piles);

        int x = piles[n - 1]; //upper limit of ans
        int y = 1; // lower limit of ans

        //[x y] is the range which follows monotonicity , we are appling bs on it to find ans 

        int ans = x;

        while (x >= y) { // Monotonicity Part 

            int guess = (x + y) / 2;

            if (fun(guess, piles, h) == true) {
                ans = guess;
                x = guess - 1;
            }

            else {
                y = guess + 1;
            }

        }
        return ans;

    }

    // The guess saying yes/no Part { O(1)/O(N)}

    public boolean fun(int guess, int[] arr, int h) {

        long hours = 0;

        for (int pile : arr) {
             hours += (int) Math.ceil((double) pile / guess);
        }

        return hours <= h;
    }
}