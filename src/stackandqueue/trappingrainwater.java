package stackandqueue;
import java.util.*;


//water kuth kuth block zal te kdhaych ahe -->height*width
//yayt aapn leftmaxbuilding and rightmaxbuilding ghenar and ya dogha mdhl min mhnjech tevdh pani adkl asnar -arr[i]
//arr[i]peksha greater pahihe left and right trch pani adkel
//prefixmax mhnje
//arr=2 1 0 5 3
//2 vr thambaych ani left la bghaych kon moth ahe saglayt ani tayla ghaych
//2 2 2 5 5
//prefix[0]=arr[0]
//for(i=1--->n-1){
//prefix[i]=max(prefix[i-1],arr[i])}

//sufixmax--->ulat
//1 11 2 10
//10 pasun start kraych eith
//11 11 10 10
//suffixmax[n-1]=arr[n-1]
//i=n-2--->0
//suffixmax[i]=max(suffix(i+1),arr[i])

//brute-->tc-->3n  sc-->2n
public class trappingrainwater {
   /* static int trap(int[] arr) {

        int n = arr.length;
    int prefix[] = new int[n];
    int suffix[] = new int[n];

    prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
        prefix[i] = Math.max(prefix[i - 1], arr[i]);
    }
    suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
        suffix[i] = Math.max(suffix[i + 1], arr[i]);
    }
    int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
        waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
    }
        return waterTrapped;
}

public static void main(String args[]) {
    int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("The duplicate element is " + trap(arr));
}
}*/
//    Output: The water that can be trapped is 6
//    Time Complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is a nested loop.
//    Space Complexity: O(1).


//optimal tc-->n sc-->1
//aaplayla fkt smaller building pahije mg ti left chi asude nahitr rightchi doni gaaj nahi so this is the optimation
//two pointer --> yaynich aapn smaller building shodhnar so small vr kam kraych

    static int trap(int[] height) {
        int n = height.length;
    int left = 0, right = n - 1;
    int res = 0;
    int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            //less first check krnra  jith check krtana zero yet ahe tith else condition run kr
        if (height[left] <= height[right]) {
            //supose maxleft greater hoyla height peksha water trape
            //max left =2 and i am getting small building water will deape else chalav nsel tr if
            if (height[left] >= maxLeft) {
                maxLeft = height[left];
            } else {
                res += maxLeft - height[left];
            }
            left++;
        }
        //right chot asel left peksha tr
        else {
            if (height[right] >= maxRight) {
                maxRight = height[right];
            } else {
                res += maxRight - height[right];
            }
            right--;
        }
    }
        return res;
}


public static void main(String args[]) {
    int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("The duplicate element is " + trap(arr));
}
}

//prefixsum ---> 1 1 1 1
//1 2 3 4