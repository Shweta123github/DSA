package BinarySearch;
//brute ---tc-->n sc--->1
/*public class FirstANDLastOccurance {
    public static int [] firstlast (int arr[],int n,int x){
        int first = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (first == -1) {
                    first = i; // Set the first occurrence
                }
                last = i; // Update the last occurrence
            }
        }

        return new int[]{first, last}; // Return the results as an array
    }


    public static void main(String[] args) {
     int arr[]={2,4,6,8,8,8,11,13};
     int n= arr.length;
     int x=8;
     int ans[]=firstlast(arr,n,x);
        System.out.println("First occurrence: " + ans[0]);
        System.out.println("Last occurrence: " + ans[1]);
    }
    }//3,4
*/

//optimal --->binary search(lower and uppear bound)  tc --->log n sc --->1

/*public class FirstANDLastOccurance {

    // Find the index of the first occurrence of x
    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Find the index of the first occurrence of x+1 and subtract 1 to get the last occurrence of x
    public static int upperBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] firstAndLastPosition(int[] arr, int n, int x) {
        int lb = lowerBound(arr, n, x);
        if (lb == n || arr[lb] != x) {
            return new int[]{-1, -1}; // x is not present in the array
        }
        return new int[]{lb, upperBound(arr, n, x) - 1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8,8, 11, 13};
        int x = 8;
        int n = arr.length;
        int[] result = firstAndLastPosition(arr, n, x);
        System.out.println(result[0] + "," + result[1]);
    }
}// 3,5
*/


//now by plan binary search not using bound


/*public class FirstANDLastOccurance {

    // Find the index of the first occurrence of k
    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1; // Search in the left half for the first occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    // Find the index of the last occurrence of k
    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1; // Search in the right half for the last occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    // Find both the first and last positions of k
    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == -1) {
            return new int[]{-1, -1}; // k is not present in the array
        }
        int last = lastOccurrence(arr, n, k);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 11, 13};
        int k = 8;
        int n = arr.length;
        int[] result = firstAndLastPosition(arr, n, k);

        System.out.println(result[0] + "," + result[1]);
    }
}
*/

//count occurance of given number


public class FirstANDLastOccurance {

    // Find the index of the first occurrence of k
    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1; // Search in the left half for the first occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    // Find the index of the last occurrence of k
    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1; // Search in the right half for the last occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    // Find both the first and last positions of k
    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == -1) {
            return new int[]{-1, -1}; // k is not present in the array
        }
        int last = lastOccurrence(arr, n, k);
        return new int[]{first, last}; //3,4 index
    }

    public static int countOccurrences(int[] arr, int n, int k) {
        int[] index = firstAndLastPosition(arr, n, k);
        if (index[0] == -1) {
            return 0; // k is not present in the array
        }
        return index[1] - index[0] + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 11, 13};
        int k = 8;
        int n = arr.length;
        int[] result = firstAndLastPosition(arr, n, k);

        System.out.println(result[0] + "," + result[1]);

        int count = countOccurrences(arr, n, k);
        System.out.println("Count of " + k + ": " + count);
    }
}
//*/



