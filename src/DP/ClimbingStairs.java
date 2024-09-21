package DP;

//final step vr jaych ahe actual kiti ways ni janar taych count return
//how to undersatnad its dp/recurison ---> supoose they say count total ways ,there are multiple ways to do
// this but give me min/max
//if you get intution from a problem like he is asking for trying out all possible ways and from that
//count ,give me best count use recursion and then go for DP.

//always do this wgen going for dp
//1-->convert problems in index
//2-->do all possinble stuff on that index
//3-->sum of all stuff -->count all ways then min of all stuff then max

//same fibonaachi logic yenar last 3 problem ghe solution mhnun
public class ClimbingStairs {

//recursion
  /*  public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}*/

  //memoiation
   /* public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }
        return memo.get(n);
    }
}*/


  //tabulation
  /*  public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}*/

    //optimization
    /*public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }*/
}

