package Arrays;
import java.util.*;

/*
brute ---> tc-->nlogn  sc-->n
Intuition:

We can sort the array in ascending order, hence the largest element will be at the last index of the array.

Approach:

Sort the array in ascending order.
Print the (size of the array -1)th index.

The Largest element in the array is: 5
The Largest element in the array is: 10
 */

public class FindtheLargestelementinanarray {
 /*   public static void main(String args[]) {

        int arr1[] =  {2,5,1,3,0};
        System.out.println("The Largest element in the array is: " + sort(arr1));

        int arr2[] =  {8,10,5,7,9};
        System.out.println("The Largest element in the array is: " + sort(arr2));
    }
    static int sort(int arr[]) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
*/


//optimal --->recursive --->Time Complexity: O(N)
//Space Complexity: O(1)

public static void main(String args[]) {

    int arr1[] =  {2,5,1,3,0};
    System.out.println("The Largest element in the array is: "+findLargestElement(arr1));

    int arr2[] =  {8,10,5,7,9};
    System.out.println("The Largest element in the array is: "+findLargestElement(arr2));
}
static int findLargestElement(int arr[]) {
    int max= arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max= arr[i];
        }
    }
    return max;
}
}

