class Solution {
    public int countGoodNumbers(long n) {
        long o; // no of  odd pos
        long e; // no of  even pos 
        int mod =1000000007;

        if (n % 2 == 0) {
            o = n / 2;
            e = n / 2;
        } else {
            o = n / 2;
            e= (n / 2) + 1;
        }
       return (int)((calculatePower(5, e) * calculatePower(4, o)) % mod);
       
    }

    public long calculatePower(int x, long power){
         int  mod =1000000007;

        if (power==0) return 1;

        long half = calculatePower(x,power/2);

        if(power%2==0){
            return( half*half % mod)  ;
        }
        else{
            return(( (half*half) %mod) *x) %mod;
        }


    }
}