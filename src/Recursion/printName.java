package Recursion;

/*
public class printName {


    public static void main(String[] args) {
        String name="shweta";
        int n=5;
        printName(name,1,n);
    }
    public static void printName(String name,int i, int n){
        if (i<=n) {
            System.out.println(name);
            printName(name,i+1,n);
        }}}
*/

/*public class printName {
    public static void main(String[] args) {
         int n=5;
         printNumber(1,n);

    }
    public static void printNumber(int i, int n){
        if(i<=n){
            System.out.println(i);
            printNumber(i+1,n);
        }}}

        */

/*
public class printName {
    public static void main(String[] args) {
        int n=5;
        printNumber(1,n);

    }
    public static void printNumber(int i, int n){
        if(i<=n){
            System.out.println(n-i+1);
            printNumber(i+1,n);
        }
    }
}*/

/*
The code first makes all the recursive calls until it reaches the base case where n is 0. Then,
it prints the values of n in reverse order as the recursion unwinds, resulting in printing from 1 to 5.

public class printName {
    public static void main(String[] args) {
        int n = 5;
        printNumber(n, n);
    }

    public static void printNumber(int i, int n) {
        if (n > 0) {
            printNumber(i, n - 1);
            System.out.println(n);
        }
    }
}
*/

/*
public class printName {
    public static void main(String[] args) {
        int n = 5;
        calculatesum(n, 0);
    }

    public static void calculatesum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        calculatesum(i - 1, sum + i);
    }
}
*/

/*
public class printName {
    public static void main(String[] args) {
        int n = 5;
        int sum = calculatesum(n);
        System.out.println("Sum of first " + n + " numbers is: " + sum);

    }

    public static int calculatesum(int n) {
        if (n > 1) {
            return n +calculatesum(n - 1);
        } else {
            return 1;
        }
    }
}*/

/*
public class printName {
    public static void main(String[] args) {
        int n = 5;
        factorial(n, 1);

    }

    public static void factorial(int i, int factorial) {
        if (i < 1) {
            System.out.println(factorial);
            return;
        }
        factorial(i - 1, factorial * i);
    }

}*/
/*
public class printName {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        Reversearray(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
        public static void Reversearray( int[] arr,int l,int r){
            if (l >= r) {
                return;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            Reversearray(arr, l + 1, r - 1);
        }
    }
*/
/*
public class printName {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        Reversearray(arr, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void Reversearray( int[] arr,int i){
        int n= arr.length;
        if (i >= n/2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;

        Reversearray(arr,i+1);
    }
}*/
/*

public class printName {
    public static void main(String[] args) {
        String s = "madam";
        boolean result = ispalindrome(s, 0);

        if (result) {
            System.out.println("The given string is a palindrome");
        } else {
            System.out.println("The given string is not a palindrome");
        }
    }


    public static boolean ispalindrome(String s, int i) {
        int n = s.length();
        if (i >= n / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(n - i - 1)) {
            return false;
        }
      return ispalindrome(s, i + 1);
    }

}*/
/*public class printName {
    public static void main(String[] args) {
        int n =6;
        int result=fibonacci(n);
        System.out.println("The "+n+"th Fibonacci number is: "+result);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int n1 = fibonacci(n - 1);
        int n2 = fibonacci(n - 2);
        return n1 + n2;
    }
}*/