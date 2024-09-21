package DP;
import java.util.*;


//same activity 2 days ch eka pathopath kraych nahi daily new pahije activity
//o/p--->max merit point
//10 50   1   -->day 0(ind)
//5  100  11  -->day 1
//max= (10+ 100)
//cirrent day+prev day

//last    activities
//0     1,2
//1       0,22
//2       0,1
//3        0,1,2


/*
 t0 t1 t2
 2  1  3 day 0
 3  4  6 day 1
 10 1  6 day 2
 8  3  7 day 3

                                                       f(3,3)

                          f(2,0)                      f(2,1)         f(2,2)
                         f(1,1)      f(1,2)

                    f(0,0)   f(0,2)

                    3+f(0,0) day=0 so return 3   3+3=6
                    6+f(0,2)  return 2    6+2=8
                    max=8

 */
//memoize
public class NinjasTraining {


        // Recursive function to calculate the maximum points for the ninja training
   /*     static int f(int day, int last, int[][] points, int[][] dp) {
            // If the result is already calculated, return it
            if (dp[day][last] != -1) return dp[day][last];

            // Base case: When it's the first day (day == 0) dirct max value daych row mdhli
            if (day == 0) {
                int maxi = 0;
                for (int i = 0; i <= 2; i++) {
                    if (i != last)
                        maxi = Math.max(maxi, points[0][i]);
                }
                return dp[day][last] = maxi; // Store and return the result
            }

            int maxi = 0;
            // Loop through the three activities on the current day
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    // Calculate the points for the current activity and recursively
                    // calculate the maximum points for the previous day
                    int activity = points[day][i] + f(day - 1, i, points, dp);
                    maxi = Math.max(maxi, activity); // Update the maximum points
                }
            }

            return dp[day][last] = maxi; // Store and return the result
        }

        // Function to find the maximum points for ninja training
        static int ninjaTraining(int n, int[][] points) {
            // Initialize a memoization table with -1 values +1 size ch create kel
            int dp[][] = new int[n][4];
            for (int[] row : dp)
                Arrays.fill(row, -1);

            // Start the recursive calculation from the last day (n - 1) with the last activity (3)
            return f(n - 1, 3, points, dp);
        }

        public static void main(String args[]) {
            // Define the points for each activity on each day
            int[][] points = {{10, 40, 70},
                    {20, 50, 80},
                    {30, 60, 90}};

            int n = points.length; // Get the number of days
            System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
        }
    }//210
*/


//tabulation
/*static int ninjaTraining(int n, int[][] points) {
    // Initialize a 2D array 'dp' to store the maximum points
    int[][] dp = new int[n][4];

    // day 0 sathiche saglech possible base condition ahet
    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][0], points[0][1]);
    dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

    // this will run ehen day>0
    for (int day = 1; day < n; day++) {
        for (int last = 0; last < 4; last++) {
            dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
            // Consider each possible task for the current day
            for (int task = 0; task <= 2; task++) {
                if (task != last) { // Ensure that the current task is different from the last
                    // Calculate the points for the current activity and add it to the maximum points from the previous day
                    int activity = points[day][task] + dp[day - 1][task];
                    // Update the maximum points for the current day and last activity
                    dp[day][last] = Math.max(dp[day][last], activity);
                }
            }
        }
    }

    // Return the maximum points achievable after all days (last activity is 3)
    return dp[n - 1][3];
}

    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
    }
}
*/

//optimization

    static int ninjaTraining(int n, int[][] points) {
        //'prev' to store the maximum points for the previous day
        int prev[] = new int[4]; //prev = {70, 70, 40, 70}


        prev[0] = Math.max(points[0][1], points[0][2]); //max(40,70) -->70
        prev[1] = Math.max(points[0][0], points[0][2]); // 10,70-->70
        prev[2] = Math.max(points[0][0], points[0][1]); // 10,40
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2])); //70

        for (int day = 1; day < n; day++) {
            //to store the maximum points for the current day and before going forward it update its value to prev
            //temp = {0, 0, 0, 0}
            int temp[] = new int[4];
            //last=0 means allowed task 1 ,2
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    //equal means run honar nahi 0 sathi
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the maximum points for the current day temp ch prev la assign
            prev = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }

    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
    }
}

//day 0 -->prev = {70, 70, 40, 70}
//day 1-->temp = {120, 120, 120, 120}   updated prev-->prev = {120, 120, 120, 120}
//day 2--->temp=temp = {210, 210, 180, 210}   updated prev -->prev = {210, 210, 180, 210}
//eith aapn fkt prev days ch thevat ahet taych adhich delete krat ahet usning prev=temp;