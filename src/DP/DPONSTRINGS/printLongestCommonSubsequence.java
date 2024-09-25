package DP.DPONSTRINGS;
import java.util.*;


/*
       b d g e k
   j 0 1 2 3 4 5
 i 0 0 0 0 0 0 0
 a 1 0 0 0 0 0 0
 b 2 0 1 1 1 1 1
 c 3 0 1 1 1 1 1
 d 4 0 1 2 2 2 2
 e 5 0 1 2 2 3 3

 start f(5,5) pasun start honar tr eith 3 jith ki e and k match hoat nahiye so he 3 ala max(3,2) pasun ala ani apn alo
 f(5,4) vr jith e & e same ahe so aapn f(4,3) vr alo jith 2 ahe tith parat check kr character jith d & g ahe je ki
 different ahe same process

 simply match hoat nsel  tr max walayla ks ja ok
 and match hoat asel tr diagnally yet ahe

 eith aapn max and diagonally move krat ahet

 */
public class printLongestCommonSubsequence {

    static void lcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        //length store kel ahe =3
        int len=dp[n][m];
        int i=n;
        int j=m;

        //length =3 ahe so yyala final string mdhe takaych mhnl tr 0 1 2 index asnar taych mul -1 kel
        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string -->str = "$$$"
        }
        StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                //eith aapn final mdhe last index pasun same char add krat ahet so ek add kel vr index-- kr
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                //diagonally jay sathi doni -- kel
                i--;
                j--;
            }
            //if not equal je greater ahe tikd ja i and j kuth pn ja doni mdhe
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }


    public static void main(String args[]) {

        String s1= "abcde";
        String s2= "bdgek";

        System.out.print("The Longest Common Subsequence is ");
        lcs(s1,s2);
    }
//Output: The Longest Common Subsequence is bde
}
