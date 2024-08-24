package Maths;

import java.util.ArrayList;
import java.util.List;

//for every query l and r denar taych mdghl prime ch count kadh  query based
//brute
public class PrintprimeInrange {
 /*   // Function to check if number is prime
    // Returns true if the number is
    // prime, false otherwise
    static boolean isPrime(int n) {
        // Counter to count the number of divisors of n
        int cnt = 0;

        // Loop from 1 to the square root of n
        for (int i = 1; i <= Math.sqrt(n); i++) {
            // Check if i is a divisor of n
            if (n % i == 0) {
                // Increment the count of divisors
                cnt++;

                // Check if i is not the square root of n
                if ((n / i) != i) {
                    // Increment the count of divisors again
                    cnt++;
                }
            }
        }

        // Check if the number of divisors is exactly 2
        return cnt == 2;  // Return true if prime, false otherwise

    }


    static List<Integer> countPrimes(List<List<Integer>> queries) {
        // Initialize list 'ans' to store the counts of primes for each query
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> query : queries) {
            // Extract the left and right
            // endpoints of the current query
            int l = query.get(0);
            int r = query.get(1);

            // Initialize a counter to count the
            // number of primes between 'l' and 'r'
            int cnt = 0;

            // Loop through each
            // number in the range [l, r)
            for (int j = l; j < r; j++) {
                // Check if the current number is
                // prime using the 'isPrime' function
                if (isPrime(j)) {
                    // If the current number is
                    // prime, increment the counter
                    cnt++;
                }
            }

            // Add the count of primes
            // for the current query into
            // the 'ans' list
            ans.add(cnt);
        }

        // Return the list containing
        // counts of primes for each query
        return ans;
    }

    public static void main(String[] args) {
        int Q = 3;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(3, 10));
        queries.add(List.of(8, 20));
        queries.add(List.of(1, 5));

        System.out.print("No. of Queries: " + queries.size() + "\nQueries: ");

        for (List<Integer> query : queries) {
            System.out.print("(" + query.get(0) + ", " + query.get(1) + ")  ");
        }

        List<Integer> result = countPrimes(queries);

        System.out.print("\nNumber of primes between the ranges: ");
        for (Integer count : result) {
            System.out.print(count + " ");
        }
        System.out.println();
    }

}
//Output No. of Queries: 3
//Queries: (3, 10) (8, 20) (1, 5)
//Number of primes between the ranges: 3 4 3


*/
    //optimal --->using sieve

        // Function to generate the Sieve of Eratosthenes to find all prime numbers up to a specified integer 'n'
        public static ArrayList<Integer> getSieve(int n) {
            // Create an ArrayList 'prime' with size 'n + 1'
            // and initialize all elements to 1, assuming all numbers are prime initially
            ArrayList<Integer> prime = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                prime.add(1);
            }
            // Mark 0 and 1 as not prime
            prime.set(0, 0);
            prime.set(1, 0);

            // Iterate from 2 to the square root of 'n'
            for (int i = 2; i <= Math.sqrt(n); ++i) {
                // Check if the current number 'i' is prime
                if (prime.get(i) == 1) {
                    // Mark multiples of 'i' as not prime
                    for (int j = i * i; j <= n; j += i) {
                        prime.set(j, 0);
                    }
                }
            }

            // Return the ArrayList containing prime indicators
            //prime = [0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0]
            return prime;
        }

        // Function to count primes between given numbers in queries
        public static ArrayList<Integer> countPrimes(ArrayList<ArrayList<Integer>> queries) {
            // Generate sieve of Eratosthenes up to a limit of 1000000
            ArrayList<Integer> prime = getSieve(1000000);

            // Initialize ArrayList 'ans' to store the counts of primes for each query
            ArrayList<Integer> ans = new ArrayList<>();
            int cnt = 0;

            // Count the primes up to each index using prefix sums
            for (int i = 2; i < prime.size(); i++) {
                cnt += prime.get(i);
                prime.set(i, cnt);
            }
            //prime = [0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 10, 10]

            // Iterate through the queries
            for (int i = 0; i < queries.size(); i++) {
                int l = queries.get(i).get(0);
                int r = queries.get(i).get(1);

                // Calculate the count of primes within the range [l, r)
                //l = 3, r = 10
                //Number of primes in range: prime[9] - prime[2] = 4 - 1 = 3
                ans.add(prime.get(r - 1) - prime.get(l - 1));
            }
            return ans;
        }

        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
            queries.add(new ArrayList<Integer>() {{
                add(3);
                add(10);
            }});
            queries.add(new ArrayList<Integer>() {{
                add(8);
                add(20);
            }});
            queries.add(new ArrayList<Integer>() {{
                add(1);
                add(5);
            }});

            System.out.println("No. of Queries: " + queries.size());
            System.out.print("Queries: ");
            for (ArrayList<Integer> query : queries) {
                System.out.print("(" + query.get(0) + ", " + query.get(1) + ")  ");
            }

            ArrayList<Integer> result = countPrimes(queries);

            System.out.println("\nNumber of primes between the ranges: ");
            for (int count : result) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
