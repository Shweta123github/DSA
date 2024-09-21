package DP;
import java.util.*;


//yayt min energy kdhaych means el step vrun dusr step vr janaysathi kamit kami energy kiti?
//so we are trying all possible ways from that taking best
//why grredy will not work -->becoz frog can take any chepier way and we'll get the final answer which can be
//max so we dont want that to avoid we'll going to try all possible ways and took min from all

//here i am assuming 0 base index thats why n-1 if we take  1th base index then we'll use n
//here we'll find f(ind-1) anad again w'll calculate the energy means difference doghan mdhl
//right sathi aapn condition lavli ki ind>1 becoz suppose mi 2 vr ahe tr obviously 1 and -1 bhtetnar
//so -1 he kamachnahi(right)

//memoization --->tc,sc-->n
public class frogjump {

  /*  static int solve(int ind,int[] height,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= solve(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
        if(ind>1)
            jumpTwo = solve(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);

        return dp[ind]=Math.min(jumpOne, jumpTwo);
    }


    public static void main(String args[]) {

        int height[]={30,10,60 , 10 , 60 , 50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(solve(n-1,height,dp));
    }
}

//40
   */


//tabulization---> tc,sc-->n

 /*   public static void main(String args[]) {

        int height[]={30,10,60,10,60,50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int ind=1;ind<n;ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= dp[ind-1] + Math.abs(height[ind]-height[ind-1]);
            if(ind>1)
                jumpTwo = dp[ind-2] + Math.abs(height[ind]-height[ind-2]);

            dp[ind]=Math.min(jumpOne, jumpTwo);
        }
        System.out.println(dp[n-1]);
    }
}*/

//optimization--->tc->n  sc-->1

    public static void main(String args[]) {

        int height[]={30,10,60,10,60,50};
        int n=height.length;
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){

            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= prev + Math.abs(height[i]-height[i-1]);
            if(i>1)
                jumpTwo = prev2 + Math.abs(height[i]-height[i-2]);

            int cur_i=Math.min(jumpOne, jumpTwo);
            prev2=prev;
            prev=cur_i;

        }
        System.out.println(prev);
    }
}






