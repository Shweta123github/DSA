package BinarySearch;

import java.util.ArrayList;
import java.util.List;
//brute--->tv--->(n1+n2)  sc--->(n1+n2)
public class MedianOfTwoSortedArray {

        public static double median(List<Integer> a, List<Integer> b) {
            List<Integer> arr3 = new ArrayList<>();
            int n1 = a.size(), n2 = b.size();
            int i = 0, j = 0;

            // Merge the two sorted arrays
            while (i < n1 && j < n2) {
                if (a.get(i) < b.get(j)) {
                    arr3.add(a.get(i++));
                } else {
                    arr3.add(b.get(j++));
                }
            }

            // Add remaining elements from array a
            while (i < n1) {
                arr3.add(a.get(i++));
            }

            // Add remaining elements from array b
            while (j < n2) {
                arr3.add(b.get(j++));
            }

            // Calculate the median
            int n = arr3.size();
            if (n % 2 == 1) {
                return arr3.get(n / 2);
            } else {
                return (arr3.get(n / 2) + arr3.get(n / 2 - 1)) / 2.0;
            }
        }

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 3, 5);
        List<Integer> b = List.of(2, 4, 6);
        System.out.println("Median: " + median(a, b)); // Output: Median: 3.5
    }
}


//optimal--->tc-->n1+n2   sc--->1
