package Arrays;

import java.util.HashSet;

//brute-->o(nlogn)+o(n)  sc-->n
//We have to think of a data structure that does not store duplicate elements.
//So can we use a Hash set? Yes! We can. As we know HashSet only stores unique elements.
public class RemoveDuplicatefromsortedarray {
  /*  public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static int removeDuplicates(int[] arr) {
        HashSet < Integer > set = new HashSet< >();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            arr[j++] = x;
        }
        return k;
    }
//1 2 3
}
*/
}
//optimal-->two pointers  tc-->n sc-->1 leetcode

//class Solution {
//    public int removeDuplicates(int[] nums) {
//        int i=0;
//        int n=nums.length;
//        for(int j=1;j<n;j++){
//            if(nums[i]!=nums[j]){
//                i++;
//                nums[i]=nums[j];
//            }
//
//        }
//        return i+1;
//    }
//}