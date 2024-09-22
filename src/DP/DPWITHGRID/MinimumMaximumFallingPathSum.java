package DP.DPWITHGRID;
import java.util.*;


//start and end doni fix nahi eith ata  max find kraych ahe  so jevha pn variable mhnel tevha explore all starting and end
//question mdhe 3 ways ni khali move krta yeyil but eith bottom pasun start ahe so ulat honar aapn vr janar 3 ways ni
//points ok
//f(n-1,0) f(n-1,1) f(n-1,2) f(n-1,3) here going from n-1 to 0   tr he f(i,j) ahe
//1 1 100
//2 2 3
//3 10 2
//                       f(2,0)
// (outofbound) f(1,-1)  f(1,0)  f(1 10)
// (outofbound) f(0,-1)  f(0,0)  f(0,10)
//ld=2+f(0,-1)  ---> -ve
//u=2+f(0,0) ---> 2+1=3
//rd=2+f(o,1)---> 2+1=3
//ive 3  3  =final ans 3

//memoization
public class MinimumMaximumFallingPathSum {
 /*       static int getMaxUtil(int i, int j, int m, int[][] matrix, int[][] dp) {
            // Base Conditions -ve ans
            if (j < 0 || j >= m)
                return (int) Math.pow(-10, 9);
            if (i == 0) //direct value return from matrix
                return matrix[0][j];

            if (dp[i][j] != -1)
                return dp[i][j];

            // Calculate three possible paths: moving up, left diagonal, and right diagonal
            int up = matrix[i][j] + getMaxUtil(i - 1, j, m, matrix, dp);
            int leftDiagonal = matrix[i][j] + getMaxUtil(i - 1, j - 1, m, matrix, dp);
            int rightDiagonal = matrix[i][j] + getMaxUtil(i - 1, j + 1, m, matrix, dp);

            // Store the maximum of the three paths in dp
            return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
        }

        // Function to find the maximum path sum in the matrix
        static int getMaxPathSum(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            int dp[][] = new int[n][m];
            for (int row[] : dp)
                Arrays.fill(row, -1);

            int maxi = Integer.MIN_VALUE;

            // For each starting column, find the maximum path sum and update maxi
            for (int j = 0; j < m; j++) {
                int ans = getMaxUtil(n - 1, j, m, matrix, dp);
                maxi = Math.max(maxi, ans);
            }

            return maxi;
        }

        public static void main(String args[]) {
            int matrix[][] = {{1, 2, 10, 4},
                    {100, 3, 2, 1},
                    {1, 1, 20, 2},
                    {1, 2, 2, 1}};

            System.out.println(getMaxPathSum(matrix));
        }
    }
    //  Output: 105
*/

//tabulation --->start to bottom

 /*   static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix already 0 satahi solve kel ahe vr for loop so start from 1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else { // -ve
                    leftDiagonal += (int) Math.pow(-10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp   -->tab sathi as kr
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }

    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
        System.out.println(getMaxPathSum(matrix));
    }
}
*/

//optimization --->0 pasun start ahe

static int getMaxPathSum(List<List<Integer>> matrix) {
    int n = matrix.size();
    int m = matrix.get(0).size();

    List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
    List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));

    // Initializing the first row - base condition i==0
    for (int j = 0; j < m; j++) {
        prev.set(j, matrix.get(0).get(j));
    }

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int up = matrix.get(i).get(j) + prev.get(j);

            int leftDiagonal = matrix.get(i).get(j);
            if (j - 1 >= 0) {
                leftDiagonal += prev.get(j - 1);
            } else {
                leftDiagonal += -1e9;
            }

            int rightDiagonal = matrix.get(i).get(j);
            if (j + 1 < m) {
                rightDiagonal += prev.get(j + 1);
            } else {
                rightDiagonal += -1e9;
            }

            // Store the maximum of the three paths in cur
            cur.set(j, Math.max(up, Math.max(leftDiagonal, rightDiagonal)));
        }

        // Update the prev list with the values from the cur list for the next row
        prev = new ArrayList<>(cur);
    }

    int maxi = Integer.MIN_VALUE;

    for (int j = 0; j < m; j++) {
        maxi = Math.max(maxi, prev.get(j));
    }

    return maxi;
}

public static void main(String args[]) {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(Arrays.asList(1, 2, 10, 4));
    matrix.add(Arrays.asList(100, 3, 2, 1));
    matrix.add(Arrays.asList(1, 1, 20, 2));
    matrix.add(Arrays.asList(1, 2, 2, 1));
    System.out.println(getMaxPathSum(matrix));
}
}
