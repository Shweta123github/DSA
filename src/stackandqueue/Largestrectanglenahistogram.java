package stackandqueue;
import java.util.*;


//je bar ghet ahot te left la kiti jaat and right la kiti jaat tech area calculate kraych ahe
//tay sathi eith pratek bar sathi prevoius smaller block and next smaller block mahiti pahije so tith paryant reactangle
//create honar
//area= l*b---> arr[i]*(pse-nse+1)
//adhi jas value pse ch value kdht hotot tas eith index store hoat ahet tay same value sathi

//brute
public class Largestrectanglenahistogram {

        public static int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Stack < Integer > st = new Stack < > ();
            //indices store
            int leftSmall[] = new int[n];
            int rightSmall[] = new int[n];

            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }

                //first check when stack is empty put o in stack
                if (st.isEmpty()) leftSmall[i] = 0;

                //eith value 5 stack mdhe takaych jagi aapn taych index takat ahet
                else leftSmall[i] = st.peek() + 1;
                st.push(i);
            }
            //leftSmall[] = {0, 0, 2, 3, 2, 5, 0}.

            // clear the stack to be re-used
            while (!st.isEmpty()) st.pop();

            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }

                if (st.isEmpty()) rightSmall[i] = n - 1;
                else rightSmall[i] = st.peek() - 1;

                st.push(i);
            }
            //rightSmall[] = {0, 6, 4, 3, 4, 5, 6}

            int maxA = 0;
            for (int i = 0; i < n; i++) {
                maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
            }
            return maxA;

        }
        public static void main(String args[]) {
            int arr[] = {2, 1, 5, 6, 2, 3, 1};
            int n = 7;
            System.out.println("The largest area in the histogram is " +
                    largestRectangleArea(arr));

        }
    }
//    Output: The largest area in the histogram is 10
//    Time Complexity: O( N )
//    Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array


//optimal ---.first loop ->maxarea so find maxprevious and next   sc,tc-->n
//second ->remaining elemnts sathi stack mdhl

/* public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
            int height = heights[stack.pop()];//index vrch elemnt
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;//empty asel tr i return kraych
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }
// i=n iteration complete zal vr pn jr kahi elemnts stcak mdhe astil tr taych stahi prt find krat ahot
    while (!stack.isEmpty()) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? n : n - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
    }

    return maxArea;
}
}
*/
