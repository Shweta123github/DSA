package DP.DPONSTRINGS;
import java.util.*;


//sagl sobat pahije letters ek sodun ek nko jas subsequence mdhe allowed ahe
//eith match nsel direct=0 kr braek krun check kraych garaj nahi
//and jr match hoat asel tr 1+kraych mhnje suppose adhi ek match bhetl and pudhe gel vr dusr bhetel prt tr 1+1=2 as
//and equal asel tr maghch check krat ahet and add krat ahot
//0 pasun start kel
public class LongestCommonSubstring {

  /*   // Function to find the length of the Longest Common Substring (LCS)
        static int lcs(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            // Create a 2D array to store LCS lengths
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0
//            0 0 0 0 0 0

            int[][] dp = new int[n + 1][m + 1];
            int ans = 0; // Initialize a variable to store the maximum LCS length

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // If the characters at the current indices are the same, extend the LCS
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        int val = 1 + dp[i - 1][j - 1];
                        dp[i][j] = val;
                        ans = Math.max(ans, val); // Update the maximum LCS length
                    } else {
                        dp[i][j] = 0; // Reset LCS length if characters don't match
                    }
                }
            }

            return ans; // Return the length of the Longest Common Substring (LCS)
        }
//                0 0 0 0 0 0
//                0 1 0 0 0 0
//                0 0 0 0 0 0
//                0 0 1 0 0 0
//                0 0 0 2 0 0
//                0 0 0 0 3 0
//                0 0 0 0 0 0
//                0 0 0 0 0 1


    public static void main(String args[]) {
            String s1 = "abcjklp";
            String s2 = "acjkp";

            // Call the lcs function and print the result
            System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
        }
    }

   // Output: The Length of Longest Common Substring is 3
*/


    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create arrays to store LCS lengths
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + prev[j - 1];
                    cur[j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    cur[j] = 0; // Reset LCS length if characters don't match
                }
            }
            // Update the 'prev' array to the values of 'cur' for the next iteration
            prev = cur.clone();
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }

    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
    }
}
