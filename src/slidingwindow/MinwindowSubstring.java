package slidingwindow;
//shortest substring containing all characters of a given string t
//brute---> n^2  sc-->256
//only shrink because we want min
public class MinwindowSubstring {
        public static String minWindow(String s, String t) {
            int[] hash = new int[256]; // Hash array to store the frequency of characters in `t`
            int minLen = Integer.MAX_VALUE; // To store the minimum length of the substring found
            int startIndex = -1; // To store the starting index of the valid minimum length substring so it
            //help to generate substrings
            int count = 0; // Count of characters from `t` that have been matched in the current window

            //hash = [0, 0, ..., 1 ('a'), 1 ('b'), 1 ('c'), ..., 0] (size 256)
            for (char ch : t.toCharArray()) {
                hash[ch]++;
            }

            int i = 0; // Start index of the current window

            for (int j = 0; j < s.length(); j++) {
                // Update hash for current character in the window
                if (hash[s.charAt(j)] > 0) {
                    count++;
                }
                hash[s.charAt(j)]--;

                // Check if the current window contains all characters of `t` means itsch tula min
                // window bhetnar becoz it has all t elements
                while (count == t.length()) {
                    // Update minimum length and starting index if a smaller window is found
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        startIndex = i;
                    }

                    // Shrink the window from the left
                    // If the character at index i is part of t and its count was contributing
                    if (hash[s.charAt(i)] == 0) {
                        count--;
                    }
                    //increase means actaul decrease ahe
                    hash[s.charAt(i)]++;
                    i++;
                }
            }

            // Return the result substring if found, otherwise return an empty string
            if (startIndex == -1) {
                return "";
            }
            return s.substring(startIndex, startIndex + minLen);
        }

        public static void main(String[] args) {
            String s = "DDAABBCA";
            String t = "ABC";
            System.out.println(minWindow(s, t)); // Output: "BCA"
        }
    }
