package Arrays.Medium;
import java.util.*;

import java.util.HashMap;

//first tyep-->n^2 sc->1
public class TwoSum {
  /*  public static String twoSum(int n, int []arr, int target) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return "YES";
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);
    }

//yes
}

*/

//second type --->tc-->n^2 sc-->1

  /*  public static int[] twoSum(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 2: [" + ans[0] + ", "
                + ans[1] + "]");
    }
//[1,3]
}
*/

//Better Approach(using Hashing):
//first type

  /*  public static String twoSum(int n, int []arr, int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                return "YES";
            }

            mpp.put(arr[i], i);
        }
        return "NO";
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);
    }

}*/

//second type
/*public static int[] twoSum(int n, int []arr, int target) {
    int[] ans = new int[2];
    ans[0] = ans[1] = -1;
    HashMap<Integer, Integer> mpp = new HashMap<>();
    for (int i = 0; i < n; i++) {
        int num = arr[i];
        int moreNeeded = target - num;
        if (mpp.containsKey(moreNeeded)) {
            ans[0] = mpp.get(moreNeeded);
            ans[1] = i;
            return ans;
        }

        mpp.put(arr[i], i);
    }
    return ans;
}

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 2: [" + ans[0] + ", "
                + ans[1] + "]");

    }

}*/

//Optimized Approach(using two-pointer):
    //tc-->O(N) + O(N*logN),  sc--->1
public static String twoSum(int n, int []arr, int target) {
    Arrays.sort(arr);
    int left = 0, right = n - 1;
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            return "YES";
        } else if (sum < target) left++;
        else right--;
    }
    return "NO";
}

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);

    }
//yes
}
