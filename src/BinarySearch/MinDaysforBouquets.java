package BinarySearch;

public class MinDaysforBouquets {

    public static boolean possible(int arr[], int day, int m, int k, int n) {
        int count = 0;
        int numberofbloom = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                numberofbloom += (count / k);
                count = 0;
            }
        }

        numberofbloom += (count / k);

        return numberofbloom >= m;
    }

    public static int rosegarden(int arr[], int k, int m, int n) {
        int value = m * k;
        if (value > n) {
            return -1;
        }

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        for (int i = mini; i <= maxi; i++) {
            if (possible(arr, i, m, k, n)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int n = arr.length;

        int ans = rosegarden(arr, k, m, n);
        if (ans == -1) {
            System.out.println("Cannot make bouquet");
        } else {
            System.out.println("Can make bouquet");
        }
    }//true
}
