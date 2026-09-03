class Solution {
    public double myPow(double x, int n) {
        long power = n;
        return calculatePower(x, power);
    }

    private double calculatePower(double x, long power) {
        if (power == 0)
            return 1;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double halfPower = calculatePower(x, power / 2);

        if (power % 2 != 0)
            return halfPower * halfPower * x;

        return halfPower * halfPower;
    }
}