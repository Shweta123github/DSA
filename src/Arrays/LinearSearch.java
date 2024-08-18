package Arrays;
//Given an array
//We will traverse the whole array and see if the element is present in the array or not
//If found we will print the index of the element
//Otherwise, we will print -1.

//tc-->n sc-->1
public class LinearSearch {
    public static int search(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if the number is not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Array of integers
        int num = 4; // Number to search for
        int val = search(arr, num); // Call search method
        System.out.println(val); // Print the result
    }
}
