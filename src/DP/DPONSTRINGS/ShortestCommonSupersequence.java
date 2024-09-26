package DP.DPONSTRINGS;
import java.util.*;


//supersequesnce means s1 and s2 mdhl sagl final string mdhe pahije te pn kamit kami mdhe
//s1=brute  s2=groot ---->bgruoote like this length =8  --->n+m-length(lcs) --->5+5-2=8
//so actually aapn lcs kdhl doghan mdhl and tayla ekch veles ghetl karn duplicate pahije nahi aaplayla
//two pointer gheun travel kr doni mdhe same asel tr ekch ghe
public class ShortestCommonSupersequence {

    static String shortestSupersequence(String s1, String s2){

        int n = s1.length();
        int m = s2.length();

        int[][] dp =new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        String ans = "";

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans += s1.charAt(i-1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += s1.charAt(i-1);
                i--;
            } else {
                ans += s2.charAt(j-1);
                j--;
            }
        }

        //Adding Remaing Characters - Only one of the below two while loops will run
        //s1=brute    s2=grute
        // bue         goo

        while(i>0){
            ans += s1.charAt(i-1);
            i--;
        }
        while(j>0){
            ans += s2.charAt(j-1);
            j--;
        }
        //reverse kel prt becaoz ulat bhetat vrun kel vr
        String ans2=new StringBuilder(ans).reverse().toString();

        return ans2;
    }

    public static void main(String args[]) {

        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Longest Common Supersequence is "+shortestSupersequence(s1,s2));
    }
}

//The Longest Common Supersequence is bgruoote --->rt remove ahe ek vels ch


