
class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        // Start placing queens from the first row
        f(0, new int[n][n], new ArrayList<>(), n);

        return ans;
    }


    public void f(int i, int[][] arr, List<Integer> usedCol, int n) {

        // All rows are filled -> store the solution
        if (i == n) {

            if (usedCol.size() == n) {
                convert(arr, n);
            }

            return;
        }


        // Try placing a queen in every column of the current row
        for (int j = 0; j < n; j++) {

            // Skip if this column already has a queen
            if (usedCol.contains(j))
                continue;


            // Place queen only if both diagonals are safe
            if (isSafe(arr, i, j, n) == true) {

                // Choose: place the queen
                arr[i][j] = 1;
                usedCol.add(j);

                // Explore: move to the next row
                f(i + 1, arr, usedCol, n);

                // Backtrack: undo the choice
                // so that the next column can be tried
                arr[i][j] = 0;
                usedCol.remove(usedCol.size() - 1);
            }
        }
    }


    public boolean isSafe(int[][] arr, int i, int j, int n) {

        int r = i;
        int c = j;


        // Check the upper-left diagonal
        while (r > 0 && c > 0) {

            if (arr[r - 1][c - 1] == 1) {
                return false;
            }

            r--;
            c--;
        }


        // Reset to the current position
        r = i;
        c = j;


        // Check the upper-right diagonal
        while (r > 0 && c < n - 1) {

            if (arr[r - 1][c + 1] == 1) {
                return false;
            }

            r--;
            c++;
        }


        // No queen found in either diagonal
        return true;
    }


    public void convert(int[][] arr, int n) {

        ArrayList<String> list = new ArrayList<>();


        // Convert the integer board into the required String format
        for (int i = 0; i < n; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 0) {
                    sb.append(".");
                }

                if (arr[i][j] == 1) {
                    sb.append("Q");
                }
            }

            list.add(sb.toString());
        }


        // Store the current valid configuration
        ans.add(list);
    }
}