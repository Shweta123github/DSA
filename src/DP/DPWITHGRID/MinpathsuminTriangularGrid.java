package DP.DPWITHGRID;
import java.util.*;


//bottom and diagnolly move krta yenar only
//ata paryant end point fixed hote n-1,m-1 as but eith fix nahiye kont pn end point asu shakat f(0,0) pasun start honar

//memoization
public class MinpathsuminTriangularGrid {

 /*   static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
        // Check if the result for the current position (i, j) is already calculated
        if (dp[i][j] != -1)
            return dp[i][j];

        // If we are at the bottom row, return the value in the triangle
        if (i == n - 1)
            return triangle[i][j];

        // Calculate the minimum path sum by recursively considering two possible paths: down and diagonal
        int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

        // Store the result in the dp array and return the minimum of the two paths
        return dp[i][j] = Math.min(down, diagonal);
    }

    // Function to find the minimum path sum in the triangle
    static int minimumPathSum(int[][] triangle, int n) {
        // Create a 2D array to store computed results, initialize with -1
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the utility function to find the minimum path sum starting from the top
        return minimumPathSumUtil(0, 0, triangle, n, dp);
    }

    public static void main(String args[]) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(minimumPathSum(triangle, n));
    }
}
//Output: 14
*/


//tabulation  --->ulat ast n-1 to 0
 /*static int minimumPathSum(int[][] triangle, int n) {
    // Create a 2D array to store intermediate results
    int dp[][] = new int[n][n];

    //base case if i==n-1 directly take value from matrix
    for (int j = 0; j < n; j++) {
        dp[n - 1][j] = triangle[n - 1][j];
    }

    // Starting from the second to last row, calculate the minimum path sum for each element
    for (int i = n - 2; i >= 0; i--) {
        for (int j = i; j >= 0; j--) {
            // Calculate the two possible paths: moving down or moving diagonally
            int down = triangle[i][j] + dp[i + 1][j];
            int diagonal = triangle[i][j] + dp[i + 1][j + 1];

            // Store the minimum of the two paths in dp
            dp[i][j] = Math.min(down, diagonal);
        }
    }

    // The result is stored at the top of dp array
    return dp[0][0];
}

    public static void main(String args[]) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;

        // Call the minimumPathSum function and print the result
        System.out.println(minimumPathSum(triangle, n));
    }
}

*/

//optimization

    static int minimumPathSum(int[][] triangle, int n) {

        int[] front = new int[n]; // Stores the results for the current row
        int[] cur = new int[n];   // Stores the results for the next row

        // Initialize the front array with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];

                // Store the minimum of the two paths in the cur array
                cur[j] = Math.min(down, diagonal);
            }

            // Update the front array with the values from the cur array for the next row
            front = cur.clone();
        }

        // The result is stored at the top of the front array
        return front[0];
    }

    public static void main(String args[]) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(minimumPathSum(triangle, n));
    }
}


