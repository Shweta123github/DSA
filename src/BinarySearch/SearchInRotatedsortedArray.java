package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
//unique elements
//brute ---> tc---> n sc-->1  linear search
/*public class SearchInRotatedsortedArray {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == k)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = 9, k = 1;
        int ans = search(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}//3
*/

//optimal -->binary search tc--->log n sc--->1


//second type --->duplicate elements--->tc--->loh n  sc--->1
//yayt only aapn low,high,mid same ale sagle the search space shrink krat ahet baki same sagl karn same numbers mdhe
//sorted check krta yenar nahi