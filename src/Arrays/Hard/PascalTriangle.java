package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

//varity 1--->tc-->o(c) sc-->1
public class PascalTriangle {
  /*  public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }
//6
}
*/
//variety 2 --->brute -->tc-->n*r  sc-->1

/*public static long nCr(int n, int r) {
    long res = 1;

    // calculating nCr:
    for (int i = 0; i < r; i++) {
        res = res * (n - i);
        res = res / (i + 1);
    }
    return res;
}

public static void pascalTriangle(int n) {
    // printing the entire row n:
    for (int c = 1; c <= n; c++) {
        System.out.print(nCr(n - 1, c - 1) + " ");
    }
    System.out.println();
}

public static void main(String[] args) {
    int n = 5;
    pascalTriangle(n);
}
}
//Output: 1 4 6 4 1
*/

//optimal---tc-->n sc--->1
/*static void pascalTriangle(int n) {
    long ans = 1;
    System.out.print(ans + " "); // printing 1st element

    // Printing the rest of the part:
    for (int i = 1; i < n; i++) {
        ans = ans * (n - i);
        ans = ans / i;
        System.out.print(ans + " ");
    }
    System.out.println();
}

public static void main(String[] args) {
    int n = 5;
    pascalTriangle(n);
}
}*/


//variety 3
//tc-->O(n*n*r) ~ O(n3), sc--->1
    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
//1
//        1 1
//        1 2 1
//        1 3 3 1
//        1 4 6 4 1


//optimal-->leetcode tc-->n^2   sc-->1