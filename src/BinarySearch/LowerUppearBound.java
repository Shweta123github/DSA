package BinarySearch;
//arr[index]>=x  ---->smallest index
//brute--->tc-->n   sc--->1  linear search
/*public class LowerUppearBound {

    public static int lowerbound(int arr[],int n,int x){
        for(int i=0;i<n;i++){
            if(arr[i]>=x){
                return i;
            }
        }
        return n;
    }
    public static void main(String[] args) {
     int arr[]={3,5,8,15,19};
     int n= arr.length;
     int x=9;
     int index=lowerbound(arr,n,x);
     System.out.println(index);
}//3
}
*/
//optimal ---> tc---> o(log n) sc--->1     binary search

public class LowerUppearBound {

    public static int lowerbound(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 8, 15, 19};
        int n = arr.length;
        int x = 9;
        int index = lowerbound(arr, n, x);
        System.out.println(index);
    }//3
}
//*/

//for Uppear bound ---->arr[index]>x
