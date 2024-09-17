package stackandqueue;
//pratek subarray mdghun min ghaych and taych sum -->smallest
//brute  tc-->n^2  sc-->1
public class sumSubarrayMins {
        public static int sumSubarrayMin(int[] arr) {
            int sum = 0;
            int mod = (int) 1e9 + 7;  // Modulus value
            int n = arr.length;

            for (int i = 0; i < n; i++) {
                int mini = arr[i];
                for (int j = i; j < n; j++) {
                    mini = Math.min(mini, arr[j]);
                    sum = (sum + mini) % mod;  // Keep sum under mod large sum ala tr  tayla handle krat
                }
            }

            return sum;
        }

        public static void main(String[] args) {
            int[] arr = {3, 1, 2, 4};
            System.out.println("Sum of Subarray Minimums: " + sumSubarrayMin(arr));
        }
    }
    //Sum of Subarray Minimums: 17

//optimal--->dilel elemnt indiviually kitii veles ala taych addition will get output  pudhun maghun min
//prevous all small   and next all small then adding pse+nse+arr[i]
//tc--->5n  sc---->5n

//import java.util.Stack;
//
//public class Solution {
//
//    public static final int MOD = 1000000007;
//
//    public int sumSubarrayMins(int[] arr) {
//        int n = arr.length;
//        int[] nse = findNSE(arr);
//        int[] pse = findPSE(arr);
//        long total = 0;
//
//        for (int i = 0; i < n; i++) {
//            int left = i - pse[i];     // Distance to the previous smaller element
//            int right = nse[i] - i;    // Distance to the next smaller element
//            total = (total + (long) right * left * arr[i]) % MOD;
//        }
//
//        return (int) total;
//    }
//
//    private int[] findNSE(int[] arr) {
//        int n = arr.length;
//        int[] nse = new int[n];
//        Stack<Integer> st = new Stack<>();
//
//        for (int i = n - 1; i >= 0; i--) {
//            while (!st.isEmpty() && arr[st.peek()] >arr[i]) {
//                st.pop();
//            }
//            nse[i] = st.isEmpty() ? n : st.peek();  // If no NSE, set to n (outside the array bounds)
//            st.push(i);
//        }
//
//        return nse;
//    }
//
//    private int[] findPSE(int[] arr) {
//        int n = arr.length;
//        int[] pse = new int[n];
//        Stack<Integer> st = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                st.pop();
//            }
//            pse[i] = st.isEmpty() ? -1 : st.peek();  // If no PSE, set to -1 (outside the array bounds)
//            st.push(i);
//        }
//
//        return pse;
//    }
//}


//index ghet ahot eithe
//arr = [71, 55, 82, 55]
//Finding the Next Smaller Element (NSE):
//
//We use a stack to find the index of the next smaller element for each element in the array from right to left.
//
//Initialize nse = [0, 0, 0, 0] and an empty stack st.
//Iteration from right to left (i = 3 to 0):
//For i = 3 (arr[3] = 55):
//Stack is empty, so there is no smaller element to the right.
//Set nse[3] = 4 (n, the length of the array).
//Push 3 onto the stack: st = [3].
//For i = 2 (arr[2] = 82):
//Stack's top element st.peek() = 3, and arr[st.peek()] = 55 is smaller than arr[2] = 82.
//So, nse[2] = 3 (index of the next smaller element).
//Push 2 onto the stack: st = [3, 2].
//For i = 1 (arr[1] = 55):
//Stack's top element st.peek() = 2, and arr[st.peek()] = 82 is larger than arr[1] = 55.
//Pop 2 from the stack.
//        Stack's top element st.peek() = 3, and arr[st.peek()] = 55 is equal to arr[1] = 55. We need strictly greater elements, so pop 3 from the stack.
//Stack is empty, so there is no smaller element to the right.
//Set nse[1] = 4 (n, the length of the array).
//Push 1 onto the stack: st = [1].
//For i = 0 (arr[0] = 71):
//Stack's top element st.peek() = 1, and arr[st.peek()] = 55 is smaller than arr[0] = 71.
//So, nse[0] = 1 (index of the next smaller element).
//Push 0 onto the stack: st = [1, 0].
//Final nse = [1, 4, 3, 4]
//
//        3. Finding the Previous Smaller Element (PSE):
//
//We use a stack to find the index of the previous smaller element for each element in the array from left to right.
//
//Initialize pse = [0, 0, 0, 0] and an empty stack st.
//Iteration from left to right (i = 0 to 3):
//For i = 0 (arr[0] = 71):
//Stack is empty, so there is no smaller element to the left.
//Set pse[0] = -1.
//Push 0 onto the stack: st = [0].
//For i = 1 (arr[1] = 55):
//Stack's top element st.peek() = 0, and arr[st.peek()] = 71 is larger than arr[1] = 55.
//Pop 0 from the stack.
//Stack is empty, so there is no smaller element to the left.
//Set pse[1] = -1.
//Push 1 onto the stack: st = [1].
//For i = 2 (arr[2] = 82):
//Stack's top element st.peek() = 1, and arr[st.peek()] = 55 is smaller than arr[2] = 82.
//So, pse[2] = 1 (index of the previous smaller element).
//Push 2 onto the stack: st = [1, 2].
//For i = 3 (arr[3] = 55):
//Stack's top element st.peek() = 2, and arr[st.peek()] = 82 is larger than arr[3] = 55.
//Pop 2 from the stack.
//        Stack's top element st.peek() = 1, and arr[st.peek()] = 55 is equal to arr[3] = 55. We need strictly greater elements, so pop 1 from the stack.
//Stack is empty, so there is no smaller element to the left.
//Set pse[3] = -1.
//Push 3 onto the stack: st = [3].
//Final pse = [-1, -1, 1, -1]
//
//        4. Main Calculation:
//
//Now, using the nse and pse arrays, we calculate the contribution of each element to the total sum of subarray minimums.
//
//        Initialize total = 0.
//Iteration from i = 0 to 3:
//For i = 0 (arr[0] = 71):
//left = i - pse[i] = 0 - (-1) = 1.
//right = nse[i] - i = 1 - 0 = 1.
//Contribution = arr[0] * left * right = 71 * 1 * 1 = 71.
//total = (total + 71) % MOD = 71.
//For i = 1 (arr[1] = 55):
//left = i - pse[i] = 1 - (-1) = 2.
//right = nse[i] - i = 4 - 1 = 3.
//Contribution = arr[1] * left * right = 55 * 2 * 3 = 330.
//total = (71 + 330) % MOD = 401.
//For i = 2 (arr[2] = 82):
//left = i - pse[i] = 2 - 1 = 1.
//right = nse[i] - i = 3 - 2 = 1.
//Contribution = arr[2] * left * right = 82 * 1 * 1 = 82.
//total = (401 + 82) % MOD = 483.
//For i = 3 (arr[3] = 55):
//left = i - pse[i] = 3 - (-1) = 4.
//right = nse[i] - i = 4 - 3 = 1.
//Contribution = arr[3] * left * right = 55 * 4 * 1 = 220.
//total = (483 + 220) % MOD = 703.
//Final total = 703.
//
