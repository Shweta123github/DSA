package Arrays;

import java.util.ArrayList;
//brute -->
//O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,
//        X = no. of non-zero elements, and N-X = total no. of zeros.
//Reason: O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. So, the total time complexity will be O(2*N).

//space Complexity: O(N)
public class MoveZerosToend {
    public static int[] moveZeros(int n, int []a) {
        //temporary array:
        ArrayList<Integer> temp = new ArrayList<>();
        //copy non-zero elements
        //from original -> temp array:
        for (int i = 0; i < n; i++) {
            if (a[i] != 0)
                temp.add(a[i]);
        }

        // number of non-zero elements.
        int nz = temp.size();

        //copy elements from temp
        //fill first nz fields of
        //original array:
        for (int i = 0; i < nz; i++) {
            a[i] = temp.get(i);
        }

        //fill rest of the cells with 0:
        for (int i = nz; i < n; i++) {
            a[i] = 0;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = 10;
        int[] ans = moveZeros(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }

}
//optimal -->using 2 pointers  tc--> n  sc--->1
