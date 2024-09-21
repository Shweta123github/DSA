package DP;
import java.util.*;


//normal recursion for fibonacci convert to memoization
public class memoization {

    static int f(int n, int[] dp){
        if(n<=1) return n;

        //check if number is already existed then return directly
        if(dp[n]!= -1) return dp[n];

        //if not go for calculation dp[n]
        return dp[n]= f(n-1,dp) + f(n-2,dp);
    }


    public static void main(String args[]) {

        int n=5;
        //dp declaration with base value -1
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(f(n,dp));

    }
}
//Output: 5
//Time Complexity: O(N)
//Reason: The overlapping subproblems will return the answer in constant time O(1).karn call jaatch nahiye call going for
//new only tahts why o(n)
//Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
//Space Complexity: O(N)
//Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
//Therefore total space complexity will be O(N) + O(N) ≈ O(N)

