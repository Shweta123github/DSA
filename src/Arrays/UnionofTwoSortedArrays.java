package Arrays;
//first:Using Map

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Why not unordered_map?
//In unordered_map the keys are stored in random order,
//while in the map the keys are stored in sorted order (ascending order by default).
//As we require elements of the union to be in ascending order, using a map is preferable.

//tc--> O( (m+n)log(m+n) )
//sc-->O(m+n) {If Space of Union ArrayList is considered}
//
//O(1) {If Space of union ArrayList is not considered}
public class UnionofTwoSortedArrays {
   /* static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        HashMap<Integer,Integer > freq=new HashMap<>();
        ArrayList<Integer> Union=new ArrayList<>();
        for (int i = 0; i < n; i++)
            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);

        for (int i = 0; i < m; i++)
            freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
        for (int it: freq.keySet())
            Union.add(it);
        return Union;
    }

    public static void main(String args[]) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }
}*/

//1 2 3 4 5 6 7 8 9 10 11 12.

//Using Set

/*static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
    HashSet <Integer> s=new HashSet<>();
    ArrayList < Integer > Union=new ArrayList<>();
    for (int i = 0; i < n; i++)
        s.add(arr1[i]);
    for (int i = 0; i < m; i++)
        s.add(arr2[i]);
    for (int it: s)
        Union.add(it);
    return Union;
}
public static void main(String args[]) {
    int n = 10, m = 7;
    int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int arr2[] = {2, 3, 4, 4, 5, 11, 12};
    ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
    System.out.println("Union of arr1 and arr2 is ");
    for (int val: Union)
        System.out.print(val+" ");
}
}
*/

//Two Pointers
    //tc-->m+n
    //sc-->m+n  sc-->1

    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer > Union=new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size()-1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size()-1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }
    public static void main(String args[]) {
        int n = 10, m = 7;
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }
}
