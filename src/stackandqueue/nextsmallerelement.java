package stackandqueue;
import java.util.*;

// pudhun check kr  stand at everyelement and look at left la check kraych eith ata element peksha lahan ahe ka bghaych
// 4 5 2 10 8
//-1 4 -1 2 2
//brute --> tc-->n^2
public class nextsmallerelement {
   /* public static int[] findNextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];

        // Traverse the array
        for (int i = 0; i < n; i++) {
            nse[i] = -1; // Initialize with -1 assuming no smaller element found
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    nse[i] = arr[j]; // Found a smaller element on the left
                    break;
                }
            }
        }
        return nse;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int[] result = findNextSmallerElements(arr);

        // Output the result
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
*/
    //same as like greater
//optimal tc,sc-->2n
    public static List<Integer> findNSE(int[] arr) {
        int n = arr.length;
        List<Integer> nse = new ArrayList<>(Collections.nCopies(n, -1)); // Initialize NSE array
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of elements

        for (int i = 0; i < n; i++) {
            // Maintain the stack to ensure elements are smaller
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // If stack is not empty, the top element is the next smaller element
            if (!stack.isEmpty()) {
                nse.set(i, stack.peek());
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return nse;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        List<Integer> result = findNSE(arr);

        System.out.println("Next Smaller Elements: " + result);
    }
}
