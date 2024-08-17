package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//brute ---> tc(n*m)+n*m log(n*m)   sc--->n*m(space of list)
/*public class Medianof2DArray {
    public static int findMedian(int[][] mat) {

        int n = mat.length;      // Number of rows
    int m = mat[0].length;   // Number of columns
    List<Integer> ls = new ArrayList<>(); // List to store matrix elements

    // Flatten the matrix into the list
        for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            ls.add(mat[i][j]);
        }
    }

    // Sort the list
        Collections.sort(ls);

    // Find the median
    int medianIndex = (n * m) / 2;
        return ls.get(medianIndex);
}

public static void main(String[] args) {
    int[][] mat = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
    };

    int median = findMedian(mat);
    System.out.println("The median is: " + median);
}
}//5

//optimal--->sc-->1  tc--->log(max-min)*n*log m
 */
/*

public class Medianof2DArray {
 

// Function to find the upper bound (upperBound equivalent)
public static int upperBound(int[] arr, int x, int n) {
    int low = 0, high = n - 1;
    int ans = n;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] > x) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}

// Function to count elements less than or equal to x (countSmallEqual equivalent)
public static int countSmallEqual(int[][] matrix, int n, int m, int x) {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        cnt += upperBound(matrix[i], x, m);
    }
    return cnt;
}

// Function to find the peak element (interpreted as median in this case)
public static int[] findmedian(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    // Find the minimum and maximum elements in the matrix
    for (int i = 0; i < n; i++) {
        low = Math.min(low, mat[i][0]);
        high = Math.max(high, mat[i][m - 1]);
    }

    int req = (n * m) / 2;
    while (low <= high) {
        int mid = (low + high) / 2;
        int smallEqual = countSmallEqual(mat, n, m, mid);
        if (smallEqual <= req) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return new int[] {low};
}

public static void main(String[] args) {
    int[][] mat = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
    };

    int[] result =findmedian(mat);
    System.out.println("The peak element (interpreted as median here) is: " + result[0]);
}
}//5

*/