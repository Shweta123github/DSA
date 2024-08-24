package Maths;
import java.util.ArrayList;
import java.util.List;

//2 is prime and mark 0 to all its multiples of 2
public class Sieve {

    // Function to find all prime
    // numbers up to 'n'
    public static List<Integer> findAllPrimes(int n) {
        // Initialize with 1 (assuming all numbers are prime initially)
        List<Integer> prime = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            prime.add(1);
        }
//prime = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]


        // 0 and 1 are not prime
        prime.set(0, 0);
        prime.set(1, 0);
        //prime = [0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

        // Apply Sieve of Eratosthenes
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (prime.get(i) == 1) {
                for (int j = i * i; j <= n; j += i) {
                    // Mark multiples of prime
                    // numbers as not prime =0
                    prime.set(j, 0);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        // Collect prime numbers
        for (int i = 2; i <= n; ++i) {
            if (prime.get(i) == 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 32;
        List<Integer> primes = findAllPrimes(n);

        System.out.println("Prime numbers less than or equal to " + n + ":");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
//Output: Prime numbers less than or equal to 32: 2 3 5 7 11 13 17 19 23 29 31
}
