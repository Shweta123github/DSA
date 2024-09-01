package Maths;
//tc--->n  sc--->n its actually 1 we are using ans array for returning only thats why 1
//n%i==0 print(i)


//optimal  tc--->sqrt(n)  sc-->1
// n=36  36*1
//2*18  3*12  4*9  6*6   9*4    12*3  repeat hoat ahe eith --->
// taymul tr sagl last paryant jayh garj nahi squareroot paryant ja fkt

import java.util.ArrayList;

public class PrintDivisorsofNumber {
    public static ArrayList<Integer> findDivisors(int n) {
        // Initialize an empty
        // ArrayList to store the divisors
        ArrayList<Integer> divisors = new ArrayList<>();

        // Iterate up to the square
        // root of n to find divisors
        // Calculate the square root of n
        int sqrtN = (int) Math.sqrt(n);

        // Loop from 1 to the
        // square root of n
        for (int i = 1; i <= sqrtN; ++i) {
            // Check if i divides n
            // without leaving a remainder
            if (n % i == 0) {
                // Add divisor i to the list
                divisors.add(i);

                // Add the counterpart divisor
                // if it's different from i
                if (i != n / i) {
                    // Add the counterpart
                    // divisor to the list
                    divisors.add(n / i);
                }
            }
        }

        // Return the list of divisors
        return divisors;
    }

    public static void main(String[] args) {
        int number = 12;
        ArrayList<Integer> divisors = findDivisors(number);

        System.out.print("Divisors of " + number + " are: ");
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
        System.out.println();
    }
}
//Divisors of 12 are: 1 12 2 6 3 4

