package stackandqueue;

//everyone should known him not required he knowns others  -->celebrity hech return kraych ahe
//0 1 1 0
//0 0 0 0
//0 1 0 0
//1 1 0 0
//person 1(row) doesnt known anyone becoz taych  smor sagl zero ahe
//suppose top knows down means he can be celebrity but if down as well known top then down cant be celebrity and both are 0
//no one be celebrity

//brute  tc-->n^2+n  sc-->2n
public class celebrity {
        public static int findCelebrity(int[][] mat, int n) {
            int[] knownMe = new int[n]; // Array to count how many people know me
            int[] iKnow = new int[n];   // Array to count how many people I know

            // Traverse the matrix to fill knownMe and iKnow arrays
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        knownMe[j]++;
                        iKnow[i]++;
                    }
                }
            }

            // Check if there's any celebrity
            for (int i = 0; i < n; i++) {
                // A celebrity is someone who is known by everyone (knownMe[i] == n - 1)
                // and knows no one (iKnow[i] == 0)
                if (knownMe[i] == n - 1 && iKnow[i] == 0) {
                    return i;
                }
            }

            return -1; // No celebrity found
        }

        public static void main(String[] args) {
            int[][] mat = {
                    {0, 1, 1},
                    {0, 0, 1},
                    {0, 0, 0}
            };
            int n = mat.length;
            int result =findCelebrity(mat, n);

            if (result == -1) {
                System.out.println("No celebrity found.");
            } else {
                System.out.println("Celebrity found at index: " + result);
            }
        }
    }
//Celebrity found at index: 2

//optimal --->tc --->2n  sc-->1
//index     0 1 2 3
//0  top-->0 1 1 0
// 1        0 0 0 0
// 2        0 1 0 0
// 3 down-->1 1 0 0
/*public int findCelebrity(int[][] mat, int n) {
    int top = 0;
    int down = n - 1;

    // Narrow down to one potential celebrity
    while (top < down) {
        if (mat[top][down] == 1) {
            top++;
        } else if (mat[down][top] == 1) {
            down--;
        } else {
            top--;
            down--;
        }
    }
    // After the loop, 'top' should be the potential celebrity
    if (top > down) return -1;

    // Verify if 'top' a celebrity--->je answer bhetl te celebrity ch condition stisfy krat ki nahi te bghaycg
    for (int i = 0; i < n; i++) {
        if (i == top) continue; // Skip checking self aaplayna garaj nahi ki top swathala olkhto he skip kel(diagnole sodun de)

    // If everyone in the row of 'top' is 0, and in the column 'top' is 1, then it's ok
    //baki sathi check krat ahet he jr false zal tr top celebrity nahi return -1
        if (mat[top][i] == 0 || mat[i][top] == 1) {
            return -1; // Not a celebrity
        }
    }
    // Return the celebrity (if found)
    return top;
}
*/