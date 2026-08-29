class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows - 1;
        int rowIdx = -1; // which row our target is in 

        while (low <= high) {     // Binary Search to Find which row can consist the targert 

            int guess = (low + high) / 2;      // here the change is in rows so low and high operating to find which row by fixing the last element of colum

            if (target == matrix[guess][cols - 1]) {
                return true;
            }

            else if (target < matrix[guess][cols - 1]) {

                rowIdx = guess;
                high = guess - 1;

            }

            else {
                low = guess + 1;
            }

        }

        if (rowIdx == -1)
            return false;

        low = 0;
        high = cols - 1; // now low ,high are focusing on colum ,here one particular row is fixed(rowIdx), change in guess is change in col no 

        while (low <= high) {

            int guess = (low + high) / 2;

            if (matrix[rowIdx][guess] == target) {
                return true;

            }

            else if (matrix[rowIdx][guess] > target) {
                high = guess - 1;
            }

            else {

                low = guess + 1;
            }
        }

        return false;

    }
}