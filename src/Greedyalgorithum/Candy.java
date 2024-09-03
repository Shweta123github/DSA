package Greedyalgorithum;

// arr---> 1 2 3 here 1 will get 1 candy 2 will get 2 candy as it have higher rating than first means left and right neighor
//1+2 =3 o/p
//1 3 2 1
//1 2 1 1 -->left consider
//1 3 2 1--->left right both consider
//1 3 2 1 --->max of left and right =final which will satisfy both left consider &left right both consider
//o/p---> 1 3 2 1=7
//brute--->tc,sc-->n

    public class Candy {
 /*   public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // Base condition: every child gets at least one candy
        left[0] = 1;
        right[n - 1] = 1;

        // Fill the left array
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // Fill the right array
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        // Calculate the maximum candies needed
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1, 0, 2}; // Example input
        System.out.println("Minimum candies needed: " + candy.candy(ratings));
    }
}//2+1+2 -->5
*/

//optimal --->slope concept
//tc--->n sc-->1


    public static int calculateCandy(int[] ratings) {
        int n = ratings.length;
        int sum = 1; // Initialize sum to 1
        int i = 1;   // Initialize i to 1

        while (i < n) {

            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Calculate peak
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Calculate down
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                down++;

            }

            // Adjust sum if necessary
            if (peak < down) {
                sum += (down - peak);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        int result = calculateCandy(ratings);
        System.out.println("Minimum candies needed: " + result);
    }
}
