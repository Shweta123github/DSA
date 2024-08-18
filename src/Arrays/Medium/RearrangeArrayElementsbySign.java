package Arrays.Medium;
import java.util.*;

import java.util.ArrayList;
//tc-->O(N+N/2)   O(N) for traversing the array once for segregating positives and negatives and another O(N/2) for adding those elements alternatively to the array, where N = size of the array A}.
//sc--->O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays,
// where N = size of the array A}.
//Variety-1--->equal postive and negative
public class RearrangeArrayElementsbySign {
 /*   public static int[] RearrangebySign(int[] A, int n){

        // Define 2 vectors, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        // Segregate the array into positives and negatives.
        for(int i=0;i<n;i++){

            if(A[i]>0) pos.add(A[i]);
            else neg.add(A[i]);
        }

        // Positives on even indices, negatives on odd.
        for(int i=0;i<n/2;i++){

            A[2*i] = pos.get(i);
            A[2*i+1] = neg.get(i);
        }


        return A;
    }

    public static void main(String args[])
    {
        // Array Initialisation.
        int n = 4;
        int A[]= {1,2,-4,-5};


        int[]ans= RearrangebySign(A,n);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }

    }
//1 -4 2 -5
}

*/
//optimal---tc,sc--->n

  /*  public static void main(String[] args) {
        // Array Initialization.
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        ArrayList<Integer> ans = RearrangebySign(A);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A) {
        int n = A.size();

        // Define array for storing the ans separately.
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        // positive elements start from 0 and negative from 1.
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {

            // Fill negative elements in odd indices and inc by 2.
            if (A.get(i) < 0) {
                ans.set(negIndex, A.get(i));
                negIndex += 2;
            }

            // Fill positive elements in even indices and inc by 2.
            else {
                ans.set(posIndex, A.get(i));
                posIndex += 2;
            }
        }

        return ans;
    }
}
*/

//Variety-2 --->not necessary positive /neative should equal
    //tc---> 2n
    // sc--->O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, w
    // here N = size of the array A}.

    public static void main(String[] args) {
        // Array Initialization
        int n = 6;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = RearrangebySign(A, n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }
}