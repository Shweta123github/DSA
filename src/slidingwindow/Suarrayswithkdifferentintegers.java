package slidingwindow;

//==k mhnl ki problem don veles colve kraych for k and k-1 times and last la sutract kraych
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

//tc--->n^2   sc--->n
public class Suarrayswithkdifferentintegers {
    public static int countSubarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>(); // Initialize the map inside the outer loop

            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1); // Update the frequency of nums[j]

                //checks if the current subarray has exactly k distinct numbers.
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break; // Break out of the loop if map size exceeds k
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3}; // Sample input
        int k = 2; // Example goal of distinct integers
        System.out.println(countSubarraysWithKDistinct(nums, k)); // Output: 7
    }
}

//no. of subarrays where different integrs <=k because jr vrch approch use kel tr most subarrays mdhle sub arrays miss hoat ahet
//tc---> 2n sc-->n

