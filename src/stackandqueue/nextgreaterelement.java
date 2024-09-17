package stackandqueue;
import java.io.*;
import java.util.*;

//monotonic stack
//till now we using stack to store elements
//but now we storing element in a specific order like increasing /decreasing known as monotonic

//yayt actually aapn maghun start krat ahet ok suppose mla 4 bhetl tr jr stak mdhe 4 peksha lahan no.asel tr kdhun takaych moth asel
//tr add krun toh no.stack mdhe update kraych
//stack empty asel tr tay traversal ch element la -1 daych --->he final answer mdhe janar kran aapn store krat ahot order ni

public class nextgreaterelement {

    public static int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int nge[] = new int[n];
            Stack < Integer > st = new Stack < > ();
            for (int i = 2 * n - 1; i >= 0; i--) {
                //top elemnt <= travelsal remove all small from stack
                while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
                    st.pop();
                }

                if (i < n) {
                    //if stack dont have anything mark it -1
                    if (st.isEmpty() == false) nge[i] = st.peek();
                    else nge[i] = -1;
                }
                //otherwise push the current element
                st.push(nums[i % n]);
            }
            return nge;
        }
        public static void main(String args[]) {
            int arr[]={5,7,1,2,6,0};

            int arr2[] = nextGreaterElements(arr);
            System.out.println("The next greater elements are ");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + " ");
            }

        }
    }
//    Output:
//
//    The next greater elements are
//    7 -1 2 6 7 5
//
//    Time Complexity: O(N)
//
//    Space Complexity: O(N)

