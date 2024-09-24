package DP.DPONSUBSEQUENCEANDSUBSETS;
import java.util.*;


//eith count kraych ahe subsets je k ch equal ahet  kahi nahi base case and addition kr fkt
public class CountSubsetswithSumK {

  /*  // Helper function to find the number of ways to achieve a target sum
        static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
            if (target == 0)
                return 1;

            //if index=0 return true otherwise false
            if (ind == 0)
                return arr[0] == target ? 1 : 0;

            if (dp[ind][target] != -1)
                return dp[ind][target];

            // Calculate the number of ways when the current element is not taken
            int notTaken = findWaysUtil(ind - 1, target, arr, dp);

            // Calculate the number of ways when the current element is taken
            int taken = 0;
            if (arr[ind] <= target)
                taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

            // Store and return the result for the current state
            return dp[ind][target] = notTaken + taken;
        }

        // Main function to find the number of ways to form subsets with a target sum
        static int findWays(int[] num, int k) {
            int n = num.length;
            int dp[][] = new int[n][k + 1];

            for (int row[] : dp)
                Arrays.fill(row, -1);

            return findWaysUtil(n - 1, k, num, dp);
        }

        public static void main(String args[]) {
            int arr[] = {1, 2, 2, 3};
            int k = 3;

            // Calculate and print the number of subsets that sum up to k
            System.out.println("The number of subsets found are " + findWays(arr, k));
        }
    }

*/
//    Output: The number of subsets found are 3

//tabulation

  /*  static int findWays(int[] num, int k) {
        int n = num.length;

        // Create a 2D DP array to store the number of ways to achieve each target sum
        int[][] dp = new int[n][k + 1];

        // Initialize the first row of the DP array
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first column of the DP array
        if (num[0] <= k) {
            dp[0][num[0]] = 1;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate the number of ways when the current element is not taken
                int notTaken = dp[ind - 1][target];

                // Calculate the number of ways when the current element is taken
                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }

                // Update the DP array for the current element and target sum
                dp[ind][target] = notTaken + taken;
            }
        }

        // The result is stored in the last cell of the DP array
        return dp[n - 1][k];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays(arr, k));
    }
}
*/

//optimization

    static int findWays(int[] num, int k) {
        int n = num.length;

        // Create an array to store the number of ways to achieve each target sum
        int[] prev = new int[k + 1];

        // Initialize the first element of the array prev = [1, 0, 0, 0, 0, 0]
        prev[0] = 1;

        // Initialize the array for the first column
        //prev = [1, 1, 0, 0, 0, 0]
        if (num[0] <= k) {
            prev[num[0]] = 1;
        }

        // Fill in the array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the number of ways for the current element
            int[] cur = new int[k + 1];

            // Initialize the first element of the current array
            cur[0] = 1; //cur = [1, 0, 0, 0, 0, 0]

            for (int target = 1; target <= k; target++) {
                // Calculate the number of ways when the current element is not taken
                int notTaken = prev[target];

                // Calculate the number of ways when the current element is taken
                int taken = 0;
                if (num[ind] <= target) {
                    taken = prev[target - num[ind]];
                }

                // Update the current array for the current element and target sum
                cur[target] = notTaken + taken;
            }

            // Update the previous array with the current array for the next iteration
            prev = cur;
        }

        // The result is stored in the last element of the array
        return prev[k];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays(arr, k));
    }
}
//3 -->o/p

