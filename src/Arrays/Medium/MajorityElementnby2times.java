package Arrays.Medium;

import java.util.HashMap;

//find the number which come more than n/2 times that will be the o/p.
//brute-->tc-->n^2  sc-->1
public class MajorityElementnby2times {

  /*  public static int majorityElement(int []v) {
        //size of the given array:
        int n = v.length;

        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (v[j] == v[i]) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return v[i];
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);

    }

//2
}
*/

//better --hashmap  tc-->O(N*logN) + O(N)  sc-->n


  /*  public static int majorityElement(int []v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);

    }

}*/
//optimal --->Moore’s Voting Algorithm:  tc-->n+n  sc-->1

}
//class Solution {
//    public int majorityElement(int[] nums) {
//        int n=nums.length;
//        int elememt=0;
//        int count=0;
//        for(int i=0;i<n;i++){
//            if(count==0){
//                count=1;
//                elememt=nums[i];
//            }else if(elememt==nums[i]) count++;
//            else count--;
//        }
//        int count1=0;
//        for(int i=0;i<n;i++){
//            if(elememt==nums[i]){
//                count1++;
//            }
//        }
//        if(count1>(n/2)) {
//            return elememt;
//        }
//        return -1;
//    }
//}