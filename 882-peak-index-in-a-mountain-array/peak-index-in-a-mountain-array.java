class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (arr[guess] > arr[guess + 1] && arr[guess] > arr[guess - 1]) {

                return guess;
            }

            else if (guess == 0) { // edge case  // when we are at '0' we cant do guess-1 but we know '0' cant be peek so we move right
                low = guess + 1;
            }

            else if (guess == n - 1) { // edge case // when we are at 'n-1' we cant do guess+1 but we know 'n-1' cant be peek so we move left
                high = guess - 1;

            } // the 2 edge cases dont req comparission because we are sure where to move ...knowing starting and ending cant be peek 

            else if (arr[guess] < arr[guess + 1] && arr[guess] > arr[guess - 1]) {
                low = guess + 1; // right side approching
                                 //guess+1 dont exist when guess=len-1 

            }

            else if (arr[guess] > arr[guess + 1] && arr[guess] < arr[guess - 1]) {
                high = guess - 1; //left side approching
                                  // guess-1 dont exist when guess=0
            }

        }

        return ans;

    }
}