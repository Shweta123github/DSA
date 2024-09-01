package slidingwindow;

//consecutive ones tr kadhch pn jr k=2 ahe ok and suppose mz javl 3 one ahet tr mi k=2 use krun ankhi 0 la 1 kru shakte
//and max consecutive kdhu shakte and then find length
//alternative we can say find longest subarray where zeros=k
//n^2   sc-->1
public class MaxConsecutiveOnes {

    public static int findMaxLength(int[] nums, int k) {
        int n = nums.length;
        int maxlen = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }

                if (zeros <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                } else {
                    break; // Exit inner loop if more than k zeros
                }
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;
        System.out.println("Maximum length of subarray with at most " + k + " zeroes: " + findMaxLength(nums, k));
    }//6
}

//better--> tc-->2n  sc-->1
//jith zero >k tith aapn l shrink krat ahet joparent te k ch equal nahi yet

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int l = 0;
        int r = 0;
        int zeros = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}

//optimal -->while kdhl fkt