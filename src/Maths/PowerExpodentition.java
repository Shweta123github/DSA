package Maths;
//2^5 ==32
//optimal--->tc-->log n  sc-->n
public class PowerExpodentition {

    // Function to calculate the power
    // of a number using iterative approach
    static double myPow(double x, int n) {
        // Initialize the result
        double ans = 1;
        // Store the original value of 'n'
        double oriNum = n;

        // If the base is 0 or 1,
        // return the base itself
        if (x == 0 || x == 1) {
            return x;
        }

        // If 'n' is negative, make 'x' its
        // reciprocal and change 'n' to its
        // absolute value minus 1
        if (n < 0) {
            x = 1 / x;
            n = -(n + 1);
            ans = ans * x;
        }

        // Loop to compute the
        // result iteratively
        while (n > 0) {
            // If 'n' is odd, multiply
            // 'ans' by 'x' and
            // decrement 'n' by 1
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            }
            // If 'n' is even, divide
            // 'n' by 2 and multiply
            // 'x' by itself
            else {
                n = n / 2;
                x = x * x;
            }
        }
        // Return the final result
        return ans;
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 21;
        System.out.println("Base: " + x);
        System.out.println("Power: " + n);

        double result = myPow(x, n);
        System.out.println("Result: " + result);
    }
}
