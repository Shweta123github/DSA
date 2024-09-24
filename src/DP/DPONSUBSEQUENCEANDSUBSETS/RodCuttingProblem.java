package DP.DPONSUBSEQUENCEANDSUBSETS;
import java.util.*;

//collect rods =n to get its max value
//rods are given all different length with their prices
//eith same number multipletime gheta yet to get max value
//actually ind start from 0 and our rodlenghts are from 1 so simple make rodlength=ind+1 else keep same
public class RodCuttingProblem {

    public static int f(int ind, int N, int[] price, int[][] dp) {
        // Base case: if we are at index 0
        //N= rodlength
        if (ind == 0) {
            return N * price[0];
        }

        // Check if the result is already in the dp array
        if (dp[ind][N] != -1) return dp[ind][N];

        // Option 1: Not take the current length
        int notTake = f(ind - 1, N, price, dp);

        // Option 2: Take the current length (only if it's possible)
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= N) {
            take = price[ind] + f(ind, N - rodLength, price, dp);
        }

        // Store the result in the dp array and return the maximum of both options
        return dp[ind][N] = Math.max(take, notTake);
    }

    public static int cutRod(int[] price, int n) {
        // Create a dp array of size n * (n+1) initialized with -1
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function starting from the last index
        return f(n - 1, n, price, dp);
    }

    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10}; // Prices for each rod length
        int n = price.length;  // Length of the rod

        System.out.println("Maximum obtainable value: " + cutRod(price, n));
    }
//12
}
