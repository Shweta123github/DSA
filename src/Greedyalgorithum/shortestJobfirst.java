package Greedyalgorithum;
import java.util.Arrays;
//first process mdhun second jayla kiti time lagel kamit kami
// 0---1---3----6---10---17==20
//20/5--->4 answer
//sort first
public class shortestJobfirst {
    static float shortestJobFirst(int[] jobs) {
        Arrays.sort(jobs);

        float waitTime = 0;
        int totalTime = 0;
        int n = jobs.length;

        for (int i = 0; i < n; ++i) {

            // Add current total
            // time to waiting time
            waitTime += totalTime;

            // Add current job's
            // time to total time
            totalTime += jobs[i];
        }

        // Return the average waiting time
        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};

        System.out.print("Array Representing Job Durations: ");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println();

        float ans = shortestJobFirst(jobs);
        System.out.println("Average waiting time: " + ans);
    }
//4.0   tc--->O(N logN + N)  sc---> optimal
}
