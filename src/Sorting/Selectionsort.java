package Sorting;

/* public class Selectionsort {

    public static void selection_sort (int arr [],int n){
        for(int i=0;i<=n-2;i++){
            int min=i;
            for(int j=i;j<=n-1;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp= arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }

    }
    public static void main(String[] args) {

        int arr[]={64,25,12,22,11};
        int n=arr.length;
        selection_sort(arr,n);

        for(int i=0;i<n;i++){
            System.out.print(" " +arr[i]);
            // 11 12 22 25 64
        }
    }
}*/

/*public class Selectionsort {

    public static void Bubble_Sort(int arr[], int n) {

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        int n = arr.length;
        Bubble_Sort(arr, n);

        for (int i = 0; i < n; i++) {

        System.out.print(" " + arr[i]);
        // 11 12 22 25 64
    }
  }
}   */

/*
public class Selectionsort {

    public static void Optimized_Bubble_Sort(int arr[], int n) {
        //if no swaps are made then swap remains false and terminate early
                   boolean swap =false;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    //if swap occurs it sets to true
                    swap=true;
                }
            }
            //this checks is swap is false 
            if(!swap){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {11, 12, 22, 25, 64};
        int n = arr.length;
        Optimized_Bubble_Sort(arr, n);
        for (int i = 0; i < n; i++) {
        System.out.print(" " + arr[i]);
        // 11 12 22 25 64

      }
    }
 }
*/

/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Selectionsort {

    public static void merge_sort_final(int arr[], int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void merge_sort_middle(int arr[], int low, int high) {
        if (low == high) return;
        {
            int mid = (low + high) / 2;
            merge_sort_middle(arr, low, mid);
            merge_sort_middle(arr, mid + 1, high);
            merge_sort_final(arr, low, mid, high);
        }
    }

    public static void merge_sort(int arr[], int n) {
        merge_sort_middle(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        int n = arr.length;
        merge_sort(arr, n);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}           //Sorted array:[11, 12, 22, 25, 64]
*/




/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Selectionsort {

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;
            //till runs i not  crosses j till it ++,--,swap and if i crosses j it swap pivot with j
            //means we get the pivot position
        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }
            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }


            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }

        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);

        return j;
    }

    public static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pindex = partition(arr, low, high);
            qs(arr, low, pindex - 1);
            qs(arr, pindex + 1, high);
        }
    }

    public static List<Integer> quick_sort(List<Integer> arr) {                                       30
        qs(arr, 0, arr.size() - 1);
        return arr;

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(7, 6, 10, 5, 9, 2, 1, 15, 7));
        int n = arr.size();
        arr = Selectionsort.quick_sort(arr);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i)+ " ");
        }

    }      //Sorted array:
             //1 2 5 6 7 7 9 10 15
}      */