package DP.DPONSTRINGS;
import java.util.*;


//o/p-->4
//reverse kr string only and reverse kel vr jr doni mdhe comm. part asel tr tech palindrome asnar
public class LongestPalindromicSubsequence {

    /* // Function to find the length of the Longest Common Subsequence (LCS)
        static int lcs(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            //  10*10 dp create kr and -1 tak sagl mdhe
            int dp[][] = new int[n + 1][m + 1];

            for (int rows[] : dp)
                Arrays.fill(rows, -1);

            // Initialize the first row and first column with 0
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int i = 0; i <= m; i++) {
                dp[0][i] = 0;
            }

            // Fill the dp array using a bottom-up approach
            for (int ind1 = 1; ind1 <= n; ind1++) {
                for (int ind2 = 1; ind2 <= m; ind2++) {
                    if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    else
                        dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }

            return dp[n][m];
        }

        // Function to find the length of the Longest Palindromic Subsequence
        static int longestPalindromeSubsequence(String s) {
            // Create a reversed version of the input string
            //bacbcbabb
            String reversed = new StringBuilder(s).reverse().toString();

            // Calculate the LCS of the original string and its reverse
            return lcs(s, reversed);
        }

        public static void main(String args[]) {
            String s = "bbabcbcab";

            System.out.print("The Length of Longest Palindromic Subsequence is ");
            System.out.println(longestPalindromeSubsequence(s));
        }
    }*/
//               0 0 0 0 0 0 0 0 0 0
//               0 1 1 1 1 1 1 1 1 1
//               0 1 1 2 2 2 2 2 2 2
//               0 1 2 2 2 3 3 3 3 3
//               0 1 2 3 3 3 4 4 4 4
//               0 1 2 3 3 3 4 5 5 5
//               0 1 2 3 4 4 4 5 5 5
//               0 1 2 3 4 5 5 5 6 6
//               0 1 2 3 4 5 6 6 6 6
//               0 1 2 3 4 5 6 6 7 7


//   Output: The Length of Longest Palindromic Subsequence is 7


    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create two arrays to store the LCS lengths
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Base Case: Initialized to 0, as no characters matched yet.

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }

            // Update prev array to store the current values
            prev = cur.clone();
        }

        return prev[m];
    }

    // Function to find the length of the Longest Palindromic Subsequence
    static int longestPalindromeSubsequence(String s) {
        // Create a reversed version of the input string
        String reversed = new StringBuilder(s).reverse().toString();

        // Calculate the LCS of the original string and its reverse
        return lcs(s, reversed);
    }

    public static void main(String args[]) {
        String s = "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }
}


