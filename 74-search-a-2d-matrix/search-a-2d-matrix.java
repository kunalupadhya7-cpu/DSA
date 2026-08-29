class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int guess = (low + high) / 2;

            if (matrix[guess / cols][guess % cols] == target) {
                return true;
            } else if (matrix[guess / cols][guess % cols] > target) {
                high = guess - 1;
            } else {
                low = guess + 1;
            }

        }

        return false;

    }
}