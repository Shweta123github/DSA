package Arrays.Hard;
//brute--->n^3   sc--->1
public class MaxProductSubarrayinanArray {


  /*  static int maxProductSubArray(int arr[]) {
        int result = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
            for(int j=i+1;j<arr.length;j++) {
                int prod = 1;
                for(int k=i;k<=j;k++)
                    prod *= arr[k];
                result = Math.max(result,prod);
            }
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArray(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }
//20
}
*/


//better ---->n^2    sc--->1

    static int maxProductSubArray(int arr[]) {
        int result = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            int p = arr[i];
            for(int j=i+1;j<arr.length;j++) {
                result = Math.max(result,p);
                p *= arr[j];
            }
            result = Math.max(result,p);
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArray(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }
}


//optimal -->leetcode -->kanade -->tc-->n sc-->1 ---152
class Solution {
    public int maxProduct(int[] nums) {
        int prod1 = nums[0],prod2 = nums[0],result = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap prod1 and prod2 when nums[i] is negative
                int temp = prod1;
                prod1 = prod2;
                prod2 = temp;
            }

            // Calculate the maximum and minimum product up to the current index
            prod1 = Math.max(nums[i], prod1 * nums[i]);
            prod2 = Math.min(nums[i], prod2 * nums[i]);


            // Update the result with the maximum product found so far
            result = Math.max(result, prod1);
        }
        return result;
    }
}
