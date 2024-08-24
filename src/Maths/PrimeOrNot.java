package Maths;

import java.util.Scanner;

public class PrimeOrNot
{
    public static void main(String[] args) {
        System.out.println("enter the number:");
        Scanner scan =new Scanner(System.in);
        int n=scan.nextInt(); //7
        scan.close(); // Closing the scanner to prevent resource leak

        if(n<=1){
            System.out.println("number is not prime nor composite: " +n);
            return; // Exit early since the number is not prime nor composite
        }

        boolean isPrime = true; // Assume the number is prime until proven otherwise
        int c = 2;

        while (c * c <= n) {
            if (n % c == 0) {
                isPrime = false; // Found a divisor, hence not prime
                break; // Exit the loop as we found that the number is not prime
            }
            c++;
        }
        if (isPrime) {
            System.out.println("Number is prime: " + n);
        } else {
            System.out.println("Number is not prime: " + n);
        }
    }
}

//tc-->sqrt(n)  sc-->1

/*// Function to check if a
// given number is prime.
static boolean checkPrime(int n){

    // Initialize a counter variable to
    // count the number of factors.
    int cnt = 0;

    // Loop through numbers from 1
    // to the square root of n.
    for(int i = 1; i <= Math.sqrt(n); i++){

        // If n is divisible by i
        // without any remainder.
        if(n % i == 0){

            // Increment the counter.
            cnt = cnt + 1;

            // If n is not a perfect square,
            // count its reciprocal factor.
            if(n / i != i){
                cnt = cnt + 1;
            }
        }
    }

    // If the number of
    // factors is exactly 2.
    if(cnt == 2){
        // Return true, indicating
        // that the number is prime.
        return true;
    }
    // If the number of
    // factors is not 2.
    else{
        // Return false, indicating
        // that the number is not prime.
        return false;
    }
}

public static void main(String[] args) {
    int n = 1483;
    boolean isPrime = checkPrime(n);
    if(isPrime){
        System.out.println(n + " is a prime number.");
    } else {
        System.out.println(n + " is not a prime number.");
    }
}
}*/