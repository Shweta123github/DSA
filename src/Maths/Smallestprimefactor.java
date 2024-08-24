package Maths;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

//query based  tr eith kas duplicate pn return honar fkt prime factor ch return nahi honar 60
//o/p---> 2 2 3 5 as pn hech factors ch problem mdhe aapn 2 3 5 evdhch return kel hoat
//buute
public class Smallestprimefactor {
    // Function to get the prime factorization of 'n'
 /*   public static ArrayList<Integer> getPrimeFactorization(int n) {
        ArrayList<Integer> primeFactors = new ArrayList<>();

        // Start dividing 'n' by each integer starting from 2
        for (int i = 2; i <= n; i++) {
            // Check if 'i' is a factor of 'n'
            while (n % i == 0) {
                // Add 'i' to the list of prime factors
                primeFactors.add(i);
                // Divide 'n' by 'i' to remove the factor
                n = n / i;
            }
        }

        // Return the ArrayList containing the prime factors of 'n'
        return primeFactors;
    }

    // Function to process multiple queries
    public static List<List<Integer>> processQueries(List<Integer> queries) {
        List<List<Integer>> results = new ArrayList<>();

        // Process each query
        for (int number : queries) {
            // Get the prime factorization for the current number
            ArrayList<Integer> factors = getPrimeFactorization(number);
            // Add the result to the list
            results.add(factors);
        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> queries = List.of(60, 28, 12); // Example queries

        // Process the queries
        List<List<Integer>> results = processQueries(queries);

        // Print results for each query
        for (int i = 0; i < queries.size(); i++) {
            System.out.print("Prime Factors for " + queries.get(i) + ": ");
            for (int factor : results.get(i)) {
                System.out.print(factor + " ");
            }
            System.out.println();
        }
    }
}
//Prime Factors for 60: 2 2 3 5
//Prime Factors for 28: 2 2 7
//Prime Factors for 12: 2 2 3

*/
//optimal --->using spf concept basically for biger number it takes less times

    // Function to preprocess smallest prime factors (SPF) for numbers up to maxNum
    public static int[] preprocessSPF(int maxNum) {
        int[] spf = new int[maxNum + 1];
        // Initialize spf with the number itself
        for (int i = 1; i <= maxNum; i++) {
            spf[i] = i;
        }

        // Use Sieve of Eratosthenes method to fill the SPF array
        for (int i = 2; i * i <= maxNum; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxNum; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        //spf = [0, 1, 2, 3, 2, 5, 2, 7, 2, 3, 2, 11, 2, 13, 2, 3, 2, 17, 2, 19, 2]
        return spf;
    }

    // Function to process queries
//    Query 12:
//    n = 12
//    Smallest prime factor of 12 is spf[12] = 2
//    Output: 2
//    Update n: n = 12 / 2 = 6
//    Smallest prime factor of 6 is spf[6] = 2
//    Output: 2
//    Update n: n = 6 / 2 = 3
//    Smallest prime factor of 3 is spf[3] = 3
//    Output: 3
//    Update n: n = 3 / 3 = 1
//    Result for 12: [2, 2, 3]
    public static List<List<Integer>> processQueries(List<Integer> queries, int[] spf) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n : queries) {
            List<Integer> factors = new ArrayList<>();
            while (n != 1) {
                factors.add(spf[n]);
                n /= spf[n];
            }
            result.add(factors);
        }
        return result;
    }

    public static void main(String[] args) {
        int maxNum = 100000;
        int[] spf = preprocessSPF(maxNum);

        // Example queries
        List<Integer> queries = Arrays.asList(12, 15, 28);
        List<List<Integer>> result = processQueries(queries, spf);

        // Output the result
        for (List<Integer> factors : result) {
            System.out.println(factors);
        }
    }
}

//O(nloglogn) for preprocessing +O(qlogn)for processing queries -->tc
//O(n+qlogn)-->sc
//By preprocessing smallest prime factors (SPF) up to 100000, you ensure that any number
// within this range can be factorized quickly using the precomputed SPFs.
// This makes the factorization operation very efficient, reducing the complexity to near-constant time for each query.
