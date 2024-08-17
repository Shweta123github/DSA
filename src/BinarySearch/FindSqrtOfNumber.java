package BinarySearch;
//brute--->tc-->n sc--->1
public class FindSqrtOfNumber {
public static int square(int n){
    int ans=0;
    for(long i=1;i<=n;i++){
        long value=i*i;
        if(value<=(long) n){
            ans=(int) i;
        }else{
            break;
        }
    }
    return ans;
}

    public static void main(String[] args) {
 int n=28;
 int ans=square(n);
 System.out.println(ans);
    }
    }
//5