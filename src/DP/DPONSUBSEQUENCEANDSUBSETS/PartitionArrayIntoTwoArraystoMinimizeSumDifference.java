package DP.DPONSUBSEQUENCEANDSUBSETS;
import java.util.*;

//target =totalsum ghetl ahe
//eith ky mhnt ahe bgh aapn mhnt ahet aaplayla target 0 to n-1 mdhech bhetnar ahe (n-1,target)
//suppose maz javle n=5 and target =7 so obvously mla dp(4,7)==true means ya row and col mdhech subset bhetnar
//2 subsets ch sum ch difference kamit kami pahije
//s =12  s1 find kr sagl sathi taych vrun s2 bhetel subtract kr and min ghe
//suppose i am having s=3 2 7 =12
//find s1 now ---> min 0 to 12 paryant check krnar
// 0 1 2 3 4 5 6 7 8 9 10 11 12 yaytun valid s1 kdhaych ahe ata ani te last row sangel ky ky valid ahe (4,7)
//ata 3,2 7 yayna add krun jevdh pn no.  bhetel te jr 0 to 12 mdhe astil tr te aaple valid s1 asnar
//s1-->0 2 5  7 9 10 12

//so s2 is -->12  10 7 5 3 2 2 so final ans is 2 which is min difference
public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {
    /*     static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
            int totSum = 0;

            // Calculate the total sum of the array elements
            for (int i = 0; i < n; i++) {
                totSum += arr.get(i); //10
            }

            // Create a DP table to store subset sum information
            boolean[][] dp = new boolean[n][totSum + 1];
            //    0 1 2 3 4 5 6 7 8 9 10
            // 0  T t f f f f f f f f f
            //1   t t t t f f f f f f f
            //2   t t t t t t t f f f f
            //3   t t t t t t t t t t t

            // Initialize the DP table for the first row sathi dp[0][0]=0 [0][1]=0 baki false
            for (int i = 0; i <= totSum; i++) {
                dp[0][i] = (i == arr.get(0));
            }

            // Fill in the DP table using bottom-up dynamic programming second row pasun chalu
            for (int ind = 1; ind < n; ind++) {
                for (int target = 0; target <= totSum; target++) {
                    // Calculate if the current element is not taken
                    boolean notTaken = dp[ind - 1][target];

                    // Calculate if the current element is taken
                    boolean taken = false;
                    if (arr.get(ind) <= target) {
                        taken = dp[ind - 1][target - arr.get(ind)];
                    }

                    // Update the DP table for the current element and target sum
                    dp[ind][target] = notTaken || taken;
                }
            }

            int mini = Integer.MAX_VALUE;

            // Find the minimum absolute difference between two subsets
            for (int i = 0; i <= totSum; i++) {
                if (dp[n - 1][i]) {
                    int diff = Math.abs(i - (totSum - i));
                    mini = Math.min(mini, diff);
                }
            }
            return mini;
        }

        public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            int n = arr.size();
            System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
        }
    }//0
*/

//tabulation

  /*  static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create a DP table to store subset sum information
        boolean[][] dp = new boolean[n][totSum + 1];
        //initial state la false ch ast sagl

        // Initialize the DP table for the first row
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
            //  0	1	2	3	4	5	6	7	8	9	10
//            0	T	F	F	F	F	F	F	F	F	F	F
//            1	T	F	F	F	F	F	F	F	F	F	F
//            2	T	F	F	F	F	F	F	F	F	F	F
//            3	T	F	F	F	F	F	F	F	F	F	F
        }

        // Initialize the DP table for the first column
        if (arr.get(0) <= totSum) {
            dp[0][totSum] = true;
//              0	1	2	3	4	5	6	7	8	9	10
//            0	T	T	F	F	F	F	F	F	F	F	F
//            1	T	F	F	F	F	F	F	F	F	F	F
//            2	T	F	F	F	F	F	F	F	F	F	F
//            3	T	F	F	F	F	F	F	F	F	F	F
        }
//          0	1	2	3	4	5	6	7	8	9	10
//        0	T	T	F	F	F	F	F	F	F	F	F
//        1	T	F	F	F	F	F	F	F	F	F	F
//        2	T	F	F	F	F	F	F	F	F	F	F
//        3	T	F	F	F	F	F	F	F	F	F	F

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
*/

//optimization

    static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create an array to store DP results for the previous row
        boolean[] prev = new boolean[totSum + 1];

        // Initialize the DP array for the first row
        prev[0] = true;

        // Initialize the DP array for the first column
        if (arr.get(0) <= totSum) {
            prev[arr.get(0)] = true;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store DP results for the current row
            boolean[] cur = new boolean[totSum + 1];
            cur[0] = true;
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = prev[target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = prev[target - arr.get(ind)];
                }

                // Update the DP array for the current element and target sum
                cur[target] = notTaken || taken;
            }
            prev = cur;
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
    }
}
