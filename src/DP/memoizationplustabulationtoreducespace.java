package DP;

//   *      *     *    *    *
// prev2  prev1  curri
// (i-2)  (i-1)   i

//   *      *           *          *    *
//        (i-2)        (i-1)       i
//     prev2=prev1     prev=curri
//suppose i pudh gel tr obvisuly prev=curr i and prev2=prev honar right  ek ek step pudh janar means reassign honar only
public class memoizationplustabulationtoreducespace {

    public static void main(String args[]) {
        int n=5;

        //base condition
        int prev2 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++){
            int cur_i = prev2+ prev;
            prev2 = prev;
            prev= cur_i;
        }
        System.out.println(prev);


    }
}

//Time Complexity: O(N)
//Reason: We are running a simple iterative loop
//Space Complexity: O(1)
//Reason: We are not using any extra space

