package Greedyalgorithum;
import java.io.*;
import java.lang.*;
import java.util.*;
//maximize the profit and job done
//perform the jobs whose deadlines less so will get max. profit
//sort job using comparator based on profit
//tc--->O(N log N) + O(N*M).  sc--->nlogn
public class Jobsequencing {

    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    class Solve {
        // return an array of size 2 having the 0th element equal to the count
        // and 1st element equal to the maximum profit
        int[] JobScheduling(Job arr[], int n) {
            Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

            int maxi = 0;//max deadline
            for (int i = 0; i < n; i++) {
                if (arr[i].deadline > maxi) {
                    maxi = arr[i].deadline;
                }
            }

            int result[] = new int[maxi + 1];

            for (int i = 1; i <= maxi; i++) {
                result[i] = -1;
            }

            int countJobs = 0, jobProfit = 0;

            for (int i = 0; i < n; i++) {

                for (int j = arr[i].deadline; j > 0; j--) {

                    // Free slot found
                    if (result[j] == -1) {
                        result[j] = i;
                        countJobs++;
                        jobProfit += arr[i].profit;
                        break;
                    }
                }
            }

            int ans[] = new int[2];
            ans[0] = countJobs;
            ans[1] = jobProfit;
            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        Jobsequencing js = new Jobsequencing();
        Solve solver = js.new Solve(); // Create an instance of the Solve class

        // size of array
        Job[] arr = new Job[4];
        arr[0] = js.new Job(1, 4, 20);
        arr[1] = js.new Job(2, 1, 10);
        arr[2] = js.new Job(3, 2, 40);
        arr[3] = js.new Job(4, 2, 30);

        // function call
        int[] res = solver.JobScheduling(arr, 4);
        System.out.println(res[0] + " " + res[1]);
    }
}