package stackandqueue;

//suppose subarray is 2 3--->so difference 2-3 =1 yaynch sum   1 4 3  = largest-smallest 1-4=3 as
//arr=1 4 3 2
// 1  -->0
//1 4-->3
//1 4 3-->3
//1 4 3 2-->3

//4
//4 3
//4 3 2

//j=i+1 kel becoz answer mdhe first ekemnt kuthch yet nahiye subarray kadhtana taych mul
//brute  tc--->n^2  sc--1
public class sumofsubarrayranges {
        public static int sumOfSubarrayRanges(int[] arr) {
            int n = arr.length;
            int sum = 0;

            // Loop through each starting point of subarray
            for (int i = 0; i < n; i++) {
                int largest = arr[i];
                int smallest = arr[i];

                // Loop through each subarray ending at j
                for (int j = i + 1; j < n; j++) {
                    // Update largest and smallest values in the current subarray
                    largest = Math.max(largest, arr[j]);
                    smallest = Math.min(smallest, arr[j]);

                    // Add the difference to the total sum
                    sum += (largest - smallest);
                }
            }

            return sum;
        }

        public static void main(String[] args) {
            int[] arr = {71, 55, 82, 55};
            System.out.println("Sum of subarray ranges: " + sumOfSubarrayRanges(arr));
        }
    }

    //optimal---> jas sumofaubarraymin kdhl tsch max kdh
// ani ya doghana subtract kr answer bhetel
//arr=1 4 3 2
// 1  -->1-1=0
//1 4-->1-4=3
//1 4 3-->1-4=3
//1 4 3 2-->1-4=3

//4 -->4-4=0
//4 3-->4-3=1
//4 3 2-->4-2=2

//3 -->3-3=0
//3 2-->3-2=1

//2-->2-2=0

//1-1+1-4+1-4........
//sumofsubarraymax-sumofsubarraymin

//tc,sc-->n

