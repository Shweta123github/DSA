package DP;
import java.util.*;


//maghe aapn ek sodun baki doghanch sum ghet hotot ata eith je sodl ahe tech o/p mdhe daych ahe
//2 3 2--->4 we picked first and last
//2 3 2--->
//mla first and last pahijech nahi so eith ky krat ahe hen last elemnt sodl bakich je rahat ahet numbers taytun max kdh
//same for first first kdh bakich rahil taych vr same logic and final dogahn mdhun answer kdh
public class Maximumsumofnonadjacentelements2 {

    static long solve(ArrayList<Integer> arr){
        int n = arr.size();
        long prev = arr.get(0);
        long prev2 =0;

        for(int i=1; i<n; i++){
            long pick = arr.get(i);
            if(i>1)
                pick += prev2;
            long nonPick = 0 + prev;

            long cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev= cur_i;

        }
        return prev;
    }

    static long robStreet(int n, ArrayList<Integer> arr){
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        if(n==1)
            return arr.get(0);

        for(int i=0; i<n; i++){

            //first and last remove and baki ghetl sagl
            if(i!=0) arr1.add(arr.get(i));
            if(i!=n-1) arr2.add(arr.get(i));
            // arr1 -->5 1 2 6
            //arr2--->1 5 1 2
        }

        long ans1 = solve(arr1);
        long ans2 = solve(arr2);

        return Math.max(ans1,ans2);
    }
    public static void main(String args[]) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(6);
        int n=arr.size();
        System.out.println(robStreet(n,arr));

    }
//11
}
