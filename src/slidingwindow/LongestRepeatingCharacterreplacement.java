package slidingwindow;

//tc-->n^2  sc-->256
//longest substring with all charters equal and if not we can make it
//generate all sustring and then i'll find how many char i need to change
public class LongestRepeatingCharacterreplacement {

    public class MaxLengthSubstring {
        public static void main(String[] args) {
            String s = "AABABBA";
            int k = 2;
            System.out.println(findMaxLength(s, k));
        }

        public static int findMaxLength(String s, int k) {
            int maxlen = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                int[] hash = new int[26]; // Initialize hash array for 'A' to 'Z'
                int maxf = 0; // Maximum frequency of a single character in the current window

                for (int j = i; j < n; j++) {
                    hash[s.charAt(j) - 'A']++; // Increment frequency of current character
                    maxf = Math.max(maxf, hash[s.charAt(j) - 'A']); // Update max frequency

                    int changes = (j - i + 1) - maxf; // Calculate number of changes required
                    if (changes <= k) {
                        maxlen = Math.max(maxlen, j - i + 1); // Update maximum length
                    } else {
                        break; // Break if changes exceed k
                    }
                }
            }

            return maxlen;
        }
    }}//5

//optimal --.tc-->n sc--->26