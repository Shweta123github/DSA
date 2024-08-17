package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//brute --->tc-->n sc-->1
public class SearchSingleElements {

     public static int single(ArrayList<Integer> arr, int n) {
            if (n == 1) {
                return arr.get(0);
            }

            // Traverse through the array
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    // Check the first element
                    if (!arr.get(i).equals(arr.get(i + 1))) {
                        return arr.get(i);
                    }
                } else if (i == n - 1) {
                    // Check the last element
                    if (!arr.get(i).equals(arr.get(i - 1))) {
                        return arr.get(i);
                    }
                } else {
                    // Check elements in the middle
                    if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1))) {
                        return arr.get(i);
                    }
                }
            }

            // If no unique element is found
            return -1;
        }

        public static void main(String[] args) {
            ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));
            int n = arr.size();
            int ans = single(arr, n);
            System.out.println(ans + " ");
        }
    }//4

