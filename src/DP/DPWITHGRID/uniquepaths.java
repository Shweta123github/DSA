package DP.DPWITHGRID;
import java.util.*;


//start to end jaych ahe using botom and right only find ways from(0,0)---->to (m-1,n-1)
//express in i,j
//do aff stuff
//sum up all ways/max/min
//bottom pasun start kel taych mul up and left kel

/*
               f(2,2)
      up f(1,2)    f(2,1)left
 */


//memoization
public class uniquepaths {

  /*  static int countWaysUtil(int i, int j, int[][] dp) {
        // If we reach the starting cell (0, 0), there's one way to reach it.
        if (i == 0 && j == 0)
            return 1;

        // If we go out of bounds means negative index , there's no way to reach the cell.
        if (i < 0 || j < 0)
            return 0;

        // If the value for this cell is already computed, return it.
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of ways by moving up and moving left.
        int up = countWaysUtil(i - 1, j, dp);
        int left = countWaysUtil(i, j - 1, dp);

        // Store the result in the DP array and return it.
        return dp[i][j] = up + left;
    }

    // Function to count the number of ways to reach cell (m-1, n-1)
    static int countWays(int m, int n) {
        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        return countWaysUtil(m - 1, n - 1, dp);
    }

    public static void main(String args[]) {
        int m = 3;
        int n = 2;
        System.out.println(countWays(m, n));
    }
//3
}*/

//tabulation

  /*  static int countWaysUtil(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition: If we are at the top-left cell (0, 0), there's one way to reach it.
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                // Store the total number of ways to reach the current cell in the DP array
                dp[i][j] = up + left;
            }
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return dp[m - 1][n - 1];
    }

    // Function to count the number of ways to reach cell (m, n)
    static int countWays(int m, int n) {
        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Call the countWaysUtil function to calculate and return the result
        return countWaysUtil(m, n, dp);
    }

    public static void main(String args[]) {
        int m = 3;
        int n = 2;
        System.out.println(countWays(m, n));
    }
}
*/


//optimization

    static int countWays(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }

            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }

    public static void main(String args[]) {
        int m = 3;
        int n = 2;
        System.out.println(countWays(m, n));
    }
}

