package DP;
import java.util.*;


//if k=5 is given  like its allowed to jump till i+K(means 5 jumps allowed ahet) mghch problem mdhe we jumped only 2 times +1 and +2
//but if k vary continuously the code copy pasting will increase so ith aapn for loop k payant ghet ahet

//memoization tc--->n*k sc-->n
public class FrogJumpwithkDistances {
 /*   static int solveUtil(int ind, int[] height, int[] dp, int k) {
        if (ind == 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int mimSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = solveUtil(ind - j, height, dp, k) + Math.abs(height[ind] - height[ind - j]);
                mimSteps = Math.min(jump, mimSteps);
            }
        }

        return dp[ind] = mimSteps;
    }

    static int solve(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n - 1, height, dp, k);
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k));
    }
}
*/


//tabulization   tc--->n*k sc-->n

    static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; // The result is stored in the last element of dp
    }
    static int solve(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveUtil(n, height, dp, k);
    }

    public static void main(String args[]) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k));
    }
}
