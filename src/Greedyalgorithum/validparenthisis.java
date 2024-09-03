package Greedyalgorithum;

//* it replace by 3---> (*)--->(()invalid   ())invalid  ()valid
//tc-->n sc-->1
public class validparenthisis {
    public static boolean checkValidString(String s) {
        int openCount = 0, starCount = 0, closeCount = 0;

        // First pass: Left to right
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            } else {
                starCount++;
            }
        }

        starCount = 0; // Reset star count for the second pass

        // Second pass: Right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                closeCount++;
            } else if (c == '(') {
                if (closeCount > 0) {
                    closeCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            } else {
                starCount++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {"()", "(*)", "(*))", "((*)", "(*))(", "((*)())", "", "*", "(", ")"};

        for (String testCase : testCases) {
            boolean result = checkValidString(testCase);
            System.out.println("Input: \"" + testCase + "\" -> " + result);
        }
    }
}

//Input: "()" -> true
//Input: "(*)" -> true
//Input: "(*))" -> true
//Input: "((*)" -> true
//Input: "(*))(" -> false
//Input: "((*)())" -> true
//Input: "" -> true
//Input: "*" -> true
//Input: "(" -> false
//Input: ")" -> false
