package BinarySearch;
//tc--->o(log n)
/*public class Iterative {

    public static int binarysearch(int arr[],int target,int n){
        int low=0, high=n-1;

        while(low<=high){
            int mid=(low +high)/2;
            if(arr[mid]==target) return mid;
            else if (target>arr[mid]) low=mid+1;
               else high=mid-1;

        }
        return -1;
    }
    public static void main(String[] args) {
    int arr[]={3,4,6,7,9,12,16,17};
    int target=6;
    int n= arr.length;
    int index=binarysearch(arr,target,n);
    if(index==-1){
        System.out.println("the target is not present");
    }
    else{
        System.out.println("the target is present" +" " +index);

    }
    }//2
}*/

//recursive
public class Iterative {

    public static int binarysearch(int arr[], int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return binarysearch(arr, mid + 1, high, target);
        } else {
            return binarysearch(arr, low, mid - 1, target);
        }
    }

    public static int search(int arr[], int target, int n) {
        return binarysearch(arr, 0, n - 1, target);
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        int n = arr.length;
        int index = search(arr, target, n);
        if (index == -1) {
            System.out.println("the target is not present");
        } else {
            System.out.println("the target is present" + " " + index);


        }//2
    }//*/
}
