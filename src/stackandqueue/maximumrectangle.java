package stackandqueue;
import java.util.Stack;

//use histogram concept
//first convert all matrix in prefixsum keep 0 as it is
//then use same code of histogram to finad max araea for eacah row
public class maximumrectangle {

        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int n = matrix.length;
            int m = matrix[0].length;
            int maxArea = 0;

            // Initialize the prefix sum matrix
            int[][] psum = new int[n][m];

            // Step 1: Build the prefix sum for columns
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (matrix[i][j] == '1') {
                        sum += 1;
                    } else {
                        sum = 0;
                    }
                    psum[i][j] = sum;
                }
            }

            // Step 2: Apply largest histogram area calculation on each row
            for (int i = 0; i < n; i++) {
                maxArea = Math.max(maxArea, largestHistogramArea(psum[i]));
            }

            return maxArea;
        }

        // Helper function to calculate the largest rectangle area in a histogram
        private int largestHistogramArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;
            int n = heights.length;

            for (int i = 0; i <= n; i++) {
                int h = (i == n) ? 0 : heights[i];
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }

            return maxArea;
        }
    }
