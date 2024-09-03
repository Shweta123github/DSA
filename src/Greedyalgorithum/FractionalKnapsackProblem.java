package Greedyalgorithum;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

//50 weight ch ghet tech mdhejevdh number yetil ghaych
//o/p--->maximum the total value
//tc--->O(n log n + n). O(n log n)  sc---.1
public class FractionalKnapsackProblem {

    static class Item {
        int value, weight;
        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;
            if (r1 < r2) return 1;
            else if (r1 > r2) return -1;
            else return 0;
        }
    }
//    Item 1: Value-to-Weight Ratio =
//            100/20 = 5.0
//    Item 2: Value-to-Weight Ratio =
//            60/10 = 6.0
//
//    Item 3: Value-to-Weight Ratio =
//            120/30 = 4.0
//

    public static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator());
        //After sorting, the array arr is ordered as follows:
//
//    Item 2 (6.0)
//    Item 1 (5.0)
//    Item 3 (4.0)

        int curWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                int remain = W - curWeight;
                finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String args[]) {
        int n = 3, weight = 50;
        Item arr[] = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);
    }
}

//Processing Item 3: Value = 120, Weight = 30)
//Check if adding the item would exceed the knapsack capacity:
//curWeight + arr[2].weight = 30 + 30 = 60, which is > W = 50
//Only part of this item can be added:
//Calculate remaining capacity: remain = W - curWeight = 50 - 30 = 20
//Add a fraction of Item 3 based on the remaining capacity:
//Fraction of value added:
//
//        120/30×20=4.0×20=80.0
//
//
//Update finalValue += 80.0 → finalValue = 240.0
//curWeight += remain → curWeight = 50
