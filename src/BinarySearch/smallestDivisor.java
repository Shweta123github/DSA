package BinarySearch;

public class smallestDivisor {

    public static int smallestdivisor(int arr[],int n,int limit){

        int maxielement=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxielement=Math.max(maxielement,arr[i]);
        }
        //find small divisor
        for(int d=1;d<=maxielement;d++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=Math.ceil((double)(arr[i])/(double)(d));
            }
            if(sum<=limit){
                return d;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int limit=8;
        int n= arr.length;
        int ans=smallestdivisor(arr,n,limit);
        System.out.println(ans);

}
}//3
