package slidingwindow;

import java.util.HashMap;

//longest substring but inly 2 char i want like ababab not abcabc
//brute-->o(n^2*log(256))   sc-->256
public class LonestSubstrinwithkdistinctcharacters {
/*
    public static int findMaxLengthSubstringWithKDistinctChars(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                // If the map size is less than or equal to k, update maxLen
                if (map.size() <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcba";
        int k = 2;
        System.out.println("Maximum length of substring with " + k + " distinct characters: " +findMaxLengthSubstringWithKDistinctChars(s, k));
    }
}
*/

    //tc-->2(n)+ log(256)   sc-->256

/*public static int findMaxLength(String s, int k) {
    int maxLen = 0;
    int l = 0, r = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    while (r < s.length()) {
        // Increment the count of the current character
        map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

        // Shrink the window until we have at most k distinct characters
        while (map.size() > k) {
            char leftChar = s.charAt(l);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            l++;
        }

        // Update maxLen if the current window is larger
        maxLen = Math.max(maxLen, r - l + 1);

        // Expand the window
        r++;
    }

    return maxLen;
}

public static void main(String[] args) {
    String s = "eceba";
    int k = 2;
    System.out.println("Length of longest substring with at most " + k + " distinct characters: " + findMaxLength(s, k));
}
}
*/
//for optimal -->only reduce while
//tc-->o(n)+log(256)  sc-->256


public static int findMaxLength(String s, int k) {
    int maxLen = 0;
    int l = 0, r = 0;
    HashMap<Character, Integer> map = new HashMap<>();

    while (r < s.length()) {
        // Increment the count of the current character
        map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

        // Shrink the window until we have at most k distinct characters
        if (map.size() > k) {
            char leftChar = s.charAt(l);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            l++;
        }

        // Update maxLen if the current window is larger
        maxLen = Math.max(maxLen, r - l + 1);

        // Expand the window
        r++;
    }

    return maxLen;
}

public static void main(String[] args) {
    String s = "eceba";
    int k = 2;
    System.out.println("Length of longest substring with at most " + k + " distinct characters: " + findMaxLength(s, k));
}
}

