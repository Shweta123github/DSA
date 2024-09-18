package stackandqueue;
import java.util.ArrayList;
import java.util.List;

//pratek sliding window mdhl max elemnt kdh
//1 3 -1 -3 5  2 1 6  k=3
//ans: 3 3 5 5 5 3 6
//till n-k paryant ja karn last window i janar
//for j he k=3 paryant so write i+k as

//brute--> tc-->n-k*k  sc-->n-k
public class SlidingWindowMaximum {

}

    /*    public List<Integer> slidingWindowMaximum(int[] arr, int k) {
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i <= arr.length - k; i++) {
                int maxi = arr[i];
                for (int j = i; j < i + k; j++) {
                    maxi = Math.max(maxi, arr[j]);
                }
                result.add(maxi);
            }
            return result;
        }
    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();

        int[] arr = {1, 3, 2, 5, 1, 7, 2};  // Example array
        int k = 3;  // Window size

        // Call the slidingWindowMaximum method and store the result
        List<Integer> result = swm.slidingWindowMaximum(arr, k);

        // Print the result
        System.out.println("Sliding window maximums are: " + result);
    }
}*/
//Sliding window maximums are: [3, 5, 5, 7, 7]

//optimal--->here we using deque where we push elemnt from front and pop from end works pretty much same as stack
//eith simple stack mdhe 3 element paryant ch ghet ahet aapn valid asel sinario tr push otherwise pop and get max
//do this for window to window
//tc-->2n  sc-->k

   /* public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            //answer 5 elemts ch yenar ahet
            int[] result = new int[n - k + 1];
            int ri = 0;
            // store index

            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {

                // queue mdhun remove numbers out of current window range k
                if (!q.isEmpty() && q.peek() == i - k) {
                    q.poll();
                }

                // remove elemnts from deque that are smaller than current elemnt then pop out
                while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                    q.pollLast();
                }
                //push index
                q.offer(i);

//adding the maximums of the sliding windows to the result array. deque mdhun max baher krun result mdhe add krat ahot
                if (i >= k - 1) {
                    result[ri++] = nums[q.peek()];
                }
            }
            return result;
        }
    }
}*/