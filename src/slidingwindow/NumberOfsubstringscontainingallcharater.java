package slidingwindow;
//tc-->n^2  sc-->1
//all three characters ('a', 'b', and 'c') at least once.
//a=97 b=98 c=99
public class NumberOfsubstringscontainingallcharater {

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] hash = {0, 0, 0};
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a'] = 1;
                if (hash[0] + hash[1] + hash[2] == 3) {
                    count++;
                }
            }
        }

        return count;
    }//bbacba
}
//so ith jevha valid string bhetat ahe(bbac) pudh jaychi garaj nahi count krat directly add number
//count=count+(n-j);
//break;

