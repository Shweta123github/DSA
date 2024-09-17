//package stackandqueue;
//
//public class previoussmallestandgreater {
//    //PREVIOUS GREATER ELEMENT
//
//
//
//    class Solution {
//        static int [] prevGreater(int arr[], int n) {
//
//            int[] res = new int[n];
//            Stack<Integer> st = new Stack<>();
//
//            for (int i = 0; i < n; i++) {
//                while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
//                    st.pop();
//                }
//                res[i] = st.isEmpty() ? -1 : arr[st.peek()];
//                st.push(i);
//            }
//            return res;
//        }
//
//    }
//
////PREVIOUS SMALLER ELEMENT
//
//    class Solution {
//        static void prevSmaller(int arr[], int n) {
//
//
//            int[] res = new int[n];
//            Stack<Integer> st = new Stack<>();
//
//            for (int i = 0; i < n; i++) {
//                while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                    st.pop();
//                }
//                res[i] = st.isEmpty() ? -1 : arr[st.peek()];
//                st.push(i);
//            }
//            return res;
//
//        }
//    }
//
//}
