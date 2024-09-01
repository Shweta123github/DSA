package slidingwindow;
import java.util.Arrays;

//generate all substring
//brute -->tc-->n^2 sc-->256
public class LongestSubstringwithoutRepeating {
    public static int longestUniqueSubstring(String s) {
        int n = s.length();
        int maxlen = 0;

        // Create a hash array to store the last index of each character
        int[] hash = new int[256];

            for (int i = 0; i < n; i++) {
                // Reset the hash array for each new starting point
                Arrays.fill(hash, 0);

                for (int j = i; j < n; j++) {
                    if (hash[s.charAt(j)] == 1) break;//if seen break
                    hash[s.charAt(j)] = 1; // Mark character as seen
                    maxlen = Math.max(j - i + 1, maxlen); // Update max length
                }
            }

            return maxlen;
        }

        public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + longestUniqueSubstring(s));
    }
    }