package DP.DPONSTRINGS;
import java.util.*;


//we can delete anything from str1 and add it in str 2
//s1=abcd   s2=anc
//first way we can delete everything from s1 and add anc in s1 so we can get s2 and it will take 7 operation 4 for delete
//and 3 for add
//second we can delete d and d from s1 and add c  total =3 operation
//first find longest common subsequence  and then do operation add/delete
public class MinimumInsertionsandDeletionstoConvertStringonetotwo {

  /*  static int lcs(String s1, String s2) {
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

    // Function to find the minimum operations required to convert str1 to str2
    static int canYouMake(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Find the length of the LCS between str1 and str2
        int k = lcs(str1, str2); //k=2

        // The minimum operations required is the sum of the lengths of str1 and str2 minus twice the length of LCS
        return (n - k) + (m - k); // 3 operation
    }

    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                + canYouMake(str1, str2));
    }
}

//Output: The Minimum operations required to convert str1 to str2: 3


*/

//optimization
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

    // Function to find the minimum operations required to convert str1 to str2
    static int canYouMake(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Find the length of the LCS between str1 and str2
        int k = lcs(str1, str2);

        // The minimum operations required is the sum of the lengths of str1 and str2 minus twice the length of LCS
        return (n - k) + (m - k);
    }

    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: " +
                canYouMake(str1, str2));
    }
}


/*
s1=abcd=4   s2=anc =3
 lcs=ac ala
 s1 mdhun ac kdhl rahil 2 and s2 mdhun ac kdhl rahil 1 n
 and prt s1 mdhe n add kel
 4-2=2   and 3-2=1
 2+1=3
 */