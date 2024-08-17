package CodesPractice;

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
