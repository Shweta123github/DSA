package stackandqueue;
import java.util.Stack;


//jr eith right la greater nsel tr gol firun left side la pn bghta yet eith and nsel tith pn tr -1 (right kdhun magh)
// otherwise no need
//using circular array concept
//doubled given array in mind
// [2 10 12 1 11] [2 10 12 1 11] in mind double kel
//  0 1  2  3  4  5  6  7  8  9
//circular mhnl tr suppose mi 10 vr ahe ani mla pudh nahi bhetl kahi tr mi gol firun 2 je oth index vr ahe tith janar(i+n-1)
//to get the new index we are doing j%n and checking if its greater

//brute--->tc-->n^2   sc-->n
public class nextgreaterelement2 {

//    public static int[] nextGreaterElement(int[] arr) {
//        int n = arr.length;
//        int[] nge = new int[n];  // Array to store the next greater elements
//        for (int i = 0; i < n; i++) {
//            nge[i] = -1;  // Initialize NGE array with -1 (default when no greater element is found)
//            for (int j = i + 1; j < i + n; j++) {
//                int ind = j % n;  // Circular array behavior
//                if (arr[ind] > arr[i]) {
//                    nge[i] = arr[ind];  // Found the next greater element
//                    break;  // Exit inner loop once the NGE is found
//                }
//            }
//        }
//        return nge;  // Return the final NGE array after processing all elements
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {2, 10, 12, 1, 11};
//        int[] result = nextGreaterElement(arr);
//
//        // Print the result
//        for (int num : result) {
//            System.out.print(num + " ");
//        }
//    }
//    //10 12 -1 11 12
//}

//optimal--->monotonic stack  tc-->4n  sc-->2n
//double the array
//[2 10 12 1 11] [2 10 12 1 11]
// 0 1  2  3  4  5  6  7  8  9(2*n-1) maghun start


    public static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        // Loop from 2n-1 to 0 (index wrapping around for circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Pop elements from the stack while the stack is not empty
            // and the top of the stack is less than or equal to the current element
            while (!st.isEmpty() && st.peek() <= arr[i % n]) {
                st.pop();
            }

            // If we are within the bounds of the original array
            if (i < n) {
                // If stack is empty, there is no NGE, otherwise top of stack is the NGE
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            // Push the current element (considering circular nature)
            st.push(arr[i % n]);
        }

        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int[] nge = findNGE(arr);

        for (int val : nge) {
            System.out.print(val + " ");
        }
    }
}
