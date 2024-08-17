package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
//tc-->o(n*m) sc-->1
public class FindRowWithMaxNumberOf1 {

        public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
            int cnt_max = 0; //max 1 count
            int index = -1; //row index

            // traverse the matrix:
            for (int i = 0; i < n; i++) {
                int cnt_ones = 0;
                for (int j = 0; j < m; j++) {
                    cnt_ones += matrix.get(i).get(j);
                }
                if (cnt_ones > cnt_max) {
                    cnt_max = cnt_ones;
                    index = i;
                }
            }
            return index;
        }

        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
            matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
            matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

            int n = 3, m = 3;
            System.out.println("The row with the maximum number of 1's is: " +
                    rowWithMax1s(matrix, n, m));
        }
    }//index i=0


//optimal--->tc -->