class Solution {
    public long maxPairStrength(int[] nums) {

        long maxAns = 0;

        for (int i = 0; i < nums.length; i++) {

            long x = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                long y = nums[j];

                long ans = (x * y) / ((gcd(x, y)) * (gcd(x, y)));

                maxAns = Math.max(ans, maxAns);

            }

        }

        return maxAns;

    }

    public static long gcd(long a, long b) {
        if (b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}