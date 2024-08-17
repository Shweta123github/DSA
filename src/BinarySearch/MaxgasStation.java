package BinarySearch;

import java.util.Arrays;
//brute --->tc(k*n) sc-->n (howmany array )
public class MaxgasStation {

    public static double minimizeMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        Arrays.fill(howMany, 0);

        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxInd = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = (arr[i + 1] - arr[i]);
                double sectionLength = diff / (howMany[i] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }

            if (maxInd != -1) {
                howMany[maxInd]++;
            }
        }

        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = (arr[i + 1] - arr[i]);
            double sectionLength = diff / (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println("Minimized maximum distance: " + minimizeMaxDistance(arr, k));
    }
}//Minimized maximum distance: 1.3333333333333333

//optimal--->