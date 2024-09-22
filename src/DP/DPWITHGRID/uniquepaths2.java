package DP.DPWITHGRID;
import java.util.*;


//same like before but only condition is that we have -1 ok so taych vrun path jayla nko tayla sodun baki sagle
//everything is same only added this   if (i >= 0 && j >= 0 && maze[i][j] == -1)
//            return 0;

//memoization
public class uniquepaths2 {
 /*   static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;
        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of paths by moving up and left
        int up = mazeObstaclesUtil(i - 1, j, maze, dp);
        int left = mazeObstaclesUtil(i, j - 1, maze, dp);

        // Store the result and return it
        return dp[i][j] = up + left;
    }

    // Main function to calculate the number of paths through the maze
    static int mazeObstacles(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];

        // Initialize the dp array with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the helper function starting from the bottom-right cell
        return mazeObstaclesUtil(n - 1, m - 1, maze, dp);
    }

    public static void main(String args[]) {
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;
        System.out.println(mazeObstacles(n, m, maze));
    }

}//2
*/


//tabulization

    /*static int mazeObstaclesUtil(int n, int m, int[][] maze, int[][] dp) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // Base conditions
            if (i > 0 && j > 0 && maze[i][j] == -1) {
                dp[i][j] = 0; // If there's an obstacle, no paths can go through here.
                continue;
            }
            if (i == 0 && j == 0) {
                dp[i][j] = 1; // There's one valid path to the start cell.
                continue;
            }

            int up = 0;
            int left = 0;

            // Check if moving up is possible
            if (i > 0)
                up = dp[i - 1][j];

            // Check if moving left is possible
            if (j > 0)
                left = dp[i][j - 1];

            // Calculate the number of paths by adding paths from above and from the left
            dp[i][j] = up + left;
        }
    }

    // The final result is stored in the bottom-right cell of the DP matrix
    return dp[n - 1][m - 1];
}

    // Main function to calculate the number of paths through the maze
    static int mazeObstacles(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];

        // Initialize the DP matrix with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the helper function starting from the top-left cell
        return mazeObstaclesUtil(n, m, maze, dp);
    }

    public static void main(String args[]) {
        // Define the maze
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(mazeObstacles(n, m, maze));
    }
}
*/

//optimization

    static int mazeObstacles(int n, int m, int[][] maze) {
        // Initialize the previous row of the DP matrix
        int prev[] = new int[n];

        for (int i = 0; i < n; i++) {
            // Create a temporary array for the current row
            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {
                // Base conditions
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    temp[j] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1; // There's one valid path to the start cell.
                    continue;
                }

                int up = 0;
                int left = 0;

                // Check if moving up is possible
                if (i > 0)
                    up = prev[j];

                // Check if moving left is possible
                if (j > 0)
                    left = temp[j - 1];

                // Calculate the number of paths by adding paths from above and from the left
                temp[j] = up + left;
            }

            // Update the previous row with the values of the current row
            prev = temp;
        }

        // The final result is stored in the last element of the previous row
        return prev[n - 1];
    }

    public static void main(String args[]) {
        // Define the maze
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(mazeObstacles(n, m, maze));
    }
}

