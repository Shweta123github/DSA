package Arrays.Hard;

import java.util.HashMap;

//brute --->n^2   sc-->1
public class LengthofthelongestsubarraywithzeroSum {

   /* static int solve(int[] a){
        int  max = 0;
        for(int i = 0; i < a.length; ++i){
            int sum = 0;
            for(int j = i; j < a.length; ++j){
                sum += a[j];
                if(sum == 0){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }

    public static void main(String args[])
    {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(solve(a));
    }
//5
}
*/
//optimal --->hashmap  tc,sc---n

    int maxLen(int A[], int n) {

        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += A[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
