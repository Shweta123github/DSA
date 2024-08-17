package BinarySearch;

/*public class HowManyTimeArrayRotated {

    public static int min(int arr[],int n) {
        int ans = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        int n = arr.length;
        int ans = min(arr, n);
        System.out.println(ans + " ");
    }//4
}*/

public class HowManyTimeArrayRotated {

    public static int findrotation(int arr[],int n) {
        int low = 0;
        int high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //3. Checking If the Subarray is Already Sorted: means 0 position ch answer asel
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            if (arr[low] < arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {

                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2, 3};
        int n = arr.length;
        int ans = findrotation(arr, n);
        System.out.println(ans + " ");
    }//4
}//*/
