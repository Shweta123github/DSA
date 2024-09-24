package DP.DPONSUBSEQUENCEANDSUBSETS;
import java.util.*;


//subsequences-->contious and dis contigous  order follow krav lagt
//subsets -->order follow nahi kel tri chalt

//jaych sum k=4 asel he subsets kdhaych ahe kiti ahet te
//1 2 3 4 k=4  ---> 4 and 1,3  -->2 subsets

//complete array mdhe target sodaych ahe f(n-1,target) here n=index we are taking
//n-1 to 0 jaat ahet array mdhe

//yayt actually take and not take krat ahet aapn
/*
arr= 2 3 1 1   target=4
                       f(3,4)
            take f(2,3)   nottake f(2,4)
          f(1,2)  f(1,3)

    take(false)  f(0,2)true
 */
public class Subsetsumequaltotarget {

  /*  // Helper function to solve subset sum problem using dynamic programming
        static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
            // If the target sum is achieved, return true
            if (target == 0)
                return true;

            // return true
            if (ind == 0)
                return arr[0] == target;

            // If the result for this subproblem has already been calculated, return it
            if (dp[ind][target] != -1)
                return dp[ind][target] == 0 ? false : true;

            // Try not taking the current element
            boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

            // Try taking the current element if it doesn't exceed the target
            boolean taken = false;
            if (arr[ind] <= target)
                taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

            // Store the result in the DP table and return whether either option was successful
            dp[ind][target] = notTaken || taken ? 1 : 0;
            return notTaken || taken;
        }

        // Main function to check if there exists a subset with a given target sum
        static boolean subsetSumToK(int n, int k, int[] arr) {
            // Create a DP table with dimensions [n][k+1]
            //dp = [  [-1, -1, -1, -1, -1], // ind = 0
            //  [-1, -1, -1, -1, -1], // ind = 1
            //  [-1, -1, -1, -1, -1], // ind = 2
            //  [-1, -1, -1, -1, -1]  // ind = 3
            int dp[][] = new int[n][k + 1];

            // Initialize DP table with -1 (unprocessed)
            for (int row[] : dp)
                Arrays.fill(row, -1);

            // Call the recursive helper function
            return subsetSumUtil(n - 1, k, arr, dp);
        }

        public static void main(String args[]) {
            int arr[] = { 1, 2, 3, 4 };
            int k = 4;
            int n = arr.length;

            // Check if there exists a subset with the given target sum
            if (subsetSumToK(n, k, arr))
                System.out.println("Subset with the given target found");
            else
                System.out.println("Subset with the given target not found");
        }
    }//  Output: Subset with given target found

*/

//tabulization

    /*static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a boolean DP table with dimensions [n][k+1] dp created of k+1 size
        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            //dp[i][0]target
            dp[i][0] = true;
        }

        // arr[0] vrch jr target ahe tr true return kr
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}*/


//optimization
static boolean subsetSumToK(int n, int k, int[] arr) {
    // Create an array to store the previous row of the DP table
    boolean prev[] = new boolean[k + 1];
    //initial prev
    //prev = [true, false, false, false, false]  // prev[0] is true (sum 0 is always possible)

    // Initialize the first row of the DP table
    prev[0] = true;

    // Initialize the first column of the DP table  index 0 ch condition ahe fkt value equal asel tr eithch true det
    if (arr[0] <= k) {
        prev[arr[0]] = true;
    }

    // Fill in the DP table using bottom-up approach
    for (int ind = 1; ind < n; ind++) {
        // Create an array to store the current row of the DP table
        //cur = [true, false, false, false, false]
        boolean cur[] = new boolean[k + 1];

        // Initialize the first column of the current row
        cur[0] = true;

        for (int target = 1; target <= k; target++) {
            // Calculate if the current target can be achieved without taking the current element
            boolean notTaken = prev[target];

            // Calculate if the current target can be achieved by taking the current element
            boolean taken = false;
            if (arr[ind] <= target) {
                taken = prev[target - arr[ind]];
            }

            // Store the result in the current row of the DP table
            cur[target] = notTaken || taken;
        }

        // Update the previous row with the current row
        prev = cur;
    }

    // The final result is stored in the last cell of the previous row
    return prev[k];
}

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
