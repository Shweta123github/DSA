package BinarySearch;

//tc -->k(best case) worst case--->n1+n2  (traval) sc--->1
public class KThElementofSortedArray {
    public int findKthElement(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        int cnt = 0;

        // Merge arrays until we reach the k-th element
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (cnt == k - 1) return nums1[i];
                cnt++;
                i++;
            } else {
                if (cnt == k - 1) return nums2[j];
                cnt++;
                j++;
            }
        }

        // If elements left in nums1
        while (i < n1) {
            if (cnt == k - 1) return nums1[i];
            cnt++;
            i++;
        }

        // If elements left in nums2
        while (j < n2) {
            if (cnt == k - 1) return nums2[j];
            cnt++;
            j++;
        }

        // If k is out of bounds (shouldn't happen with valid input)
        return -1;
    }

    // Example usage
    public static void main(String[] args) {
        KThElementofSortedArray finder = new KThElementofSortedArray();
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int k = 4;
        System.out.println("4th element: " + finder.findKthElement(nums1, nums2, k)); // Output: 4th element: 4

    }

}
