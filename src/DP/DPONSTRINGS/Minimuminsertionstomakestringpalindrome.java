package DP.DPONSTRINGS;
import java.util.*;


//we can make any string palindrome we can add its reverse in that
//kiti character dilel string mdhe add krav lagel jene krun aaplayla palindrome bhetel
//a b c a a yayt longest pailndrome  a a a ahe rahile bc so yayla a a a mdhe tak a b c a b c a ok ata yayna compare
//kr  abc a bca he  palindrome goyil but last ch bc la reverse krav lagel line ca
// second lingest subsequence ---> a c a   rahil b a   so can get palindrome -->a b  c  a  a  --->yayt
//a a match hoat ahe pn right side la b nahi so add kr ata match honar and next left side la a nahi so add kr
//so will get a b a  c  a b a
public class Minimuminsertionstomakestringpalindrome {


    /*    // Function to find the length of the Longest Common Subsequence (LCS)
        static int lcs(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            // Create a 2D array to store the LCS lengths
            int dp[][] = new int[n + 1][m + 1];

            // Initialize the dp array with -1
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
            String reversed = new StringBuilder(s).reverse().toString();

            // Calculate the LCS of the original string and its reverse
            return lcs(s, reversed);
        }

        // Function to find the minimum insertions required to make the string palindrome
        static int minInsertion(String s) {
            int n = s.length();
            int k = longestPalindromeSubsequence(s);

            // The minimum insertions required is the difference between the string length and its
            // Longest Palindromic Subsequence length
            //total number-longest palindrome ch  length
            return n - k;
        }

        public static void main(String args[]) {
            String s = "abcaa";
            System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
        }
    }

 //   Output: The Minimum insertions required to make string palindrome: 2

*/


//optimized

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

            // Update prev array to store the current values using a clone of cur
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

    // Function to find the minimum insertions required to make the string palindrome
    static int minInsertion(String s) {
        int n = s.length();
        int k = longestPalindromeSubsequence(s);

        // The minimum insertions required is the difference between the string length and its
        // Longest Palindromic Subsequence length
        return n - k;
    }

    public static void main(String args[]) {
        String s = "abcaa";
        System.out.println("The Minimum insertions required to make the string palindrome: "
                + minInsertion(s));
    }
}
