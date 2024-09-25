package DP.DPONSTRINGS;


//subsequence are like substrings the empty string is also a subsequence and all are in order
//max javl 2 string ahet tr taynch comm subsequence mdhun longer pahije ahe mhnje doghan mdhe same
//same substring pahije any taytun longest

//1.generate all subsequences and then compare by characters
//here use 2 indexes ind1 and ind2
//if char matches from both strings do reduces the bot ind1 and ind2 by 1 and add 1+
//012      012
//acd =s1  ced=s2
//currently ind1 and ind2 at index 0 so here char matches so do 1+f(1,1) and do ind1-- and ind2--  f(1+f(ind1-1,ind2-1)
//and if not matching add 0+ max [f(ind1-1,ind2),f(ind1,ind2-1)]
//01     01
// ec    ce  ind1 and ind2  at 1 but its not matching so decrease ind1 to 0 we'll get e  ce
//and same for other decrese ind2 from 1 0 we'll get  ec  c
//so now they will match
//base case:-ve index means end of string(ind1<0 or ind2<0) return 0
//o/p-->2

//memoization
//declare dp[i][j]=-1

public class LongestCommonSubsequencelength {
       /*  static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
            // Base case: if index is -ve ,return 0
            if (ind1 < 0 || ind2 < 0)
                return 0;

            // If the result for this subproblem has already been calculated, return direct value
            if (dp[ind1][ind2] != -1)
                return dp[ind1][ind2];

            // If the characters at the current indices are the same, increment the LCS length
            if (s1.charAt(ind1) == s2.charAt(ind2))
                return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp);

                // If the characters are different, choose the maximum LCS length by either
                // skipping a character in s1 or skipping a character in s2
            else
                return dp[ind1][ind2] = Math.max(lcsUtil(s1, s2, ind1, ind2 - 1, dp),
                        lcsUtil(s1, s2, ind1 - 1, ind2, dp));
        }

        static int lcs(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            // Create a 2D array to store results of subproblems
            int dp[][] = new int[n][m];

            // Initialize the dp array with -1 to indicate that subproblems are not solved yet
            for (int rows[] : dp)
                Arrays.fill(rows, -1);

            // Call the recursive function to find the LCS length
            return lcsUtil(s1, s2, n - 1, m - 1, dp);
        }

        public static void main(String args[]) {
            String s1 = "acd";
            String s2 = "ced";
            System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
        }
    }
    //  Output: The Length of Longest Common Subsequence is 2

//    c	e	d
//a	  0	0	0
//c	  1	1	1
//d	 -1	1	2

*/

//tabulation
/*
static int lcs(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Create a 2D array to store results of subproblems
    int dp[][] = new int[n + 1][m + 1];

    // Initialize the dp array with -1 to indicate that subproblems are not solved yet
    for (int rows[] : dp)
        Arrays.fill(rows, -1);

//        Initial dp matrix:4*4 zal so extra row and col mdhe 0 takl
//
//       c	 e	 d
//  0    0	 0	 0
//a	0	-1	-1	-1
//c	0	-1	-1	-1
//d	0	-1	-1	-1


    // Initialize the first row and first column with zeros since LCS with an empty string is zero
    for (int i = 0; i <= n; i++) {
        dp[i][0] = 0;
    }
    for (int i = 0; i <= m; i++) {
        dp[0][i] = 0;
    }

    // Fill the dp array using dynamic programming
    for (int ind1 = 1; ind1 <= n; ind1++) {
        for (int ind2 = 1; ind2 <= m; ind2++) {
            // If the characters at the current indices are the same, increment the LCS length
            if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                // If the characters are different, choose the maximum LCS length by either
                // excluding a character in s1 or excluding a character in s2
            else
                dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
        }
    }

    return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
}

public static void main(String args[]) {
    String s1 = "acd";
    String s2 = "ced";

    // Call the lcs function and print the result
    System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
}
}

//  j	c	e	d
//i 0	0	0	0
//a	0	0	0	0
//c	0	1	1	1
//d	0	1	1	2
*/

//optimization
//ind1==prev   ind2=cur
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create arrays to store the LCS lengths
//        prev (initial)	0	0	0	0
//        cur (initial) 	0	0	0	0
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        // Iterate through the strings and calculate LCS lengths
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // cur mdhl prev mdhe and tech return
            prev = (int[]) (cur.clone());
        }

        return prev[m]; // Return the length of the Longest Common Subsequence (LCS)
    }

    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
    }
}

