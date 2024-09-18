package stackandqueue;
import java.util.ArrayList;
import java.util.Stack;


//current number la thambun magh(left) check kraych tay number peksha lessthan and equal kiti number
// ahet ani taych count ghaych
//eg. 7 2 1 3 3 1 8
//1 1 1 3 4 1 7

//brute --->tc-->   sc-->
public class stockspanproblem {
    private ArrayList<Integer> arr = new ArrayList<>();

    public int next(int value) {
        arr.add(value);
        int count = 1;

        // Start from the second last element and go backwards
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) <= value) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        stockspanproblem stockSpan = new stockspanproblem();

        // Test inputs
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        for (int price : prices) {
            System.out.println("Span for price " + price + " : " + stockSpan.next(price));
        }
    }
}
//Span for price 100 : 1
//Span for price 80 : 1
//Span for price 60 : 1
//Span for price 70 : 2
//Span for price 60 : 1
//Span for price 75 : 4
//Span for price 85 : 6

//optimal ---> for a particular elemnt fond pge ok and subtract it we will directly get count we dont need to traverse fully
//7 2 1 3 3 1 8    suppose elemnt =second 3 whose index 4 and for this number pge is 7 whoe index is 0 so
//simpy subtract both index 4-0=4 left to right move
//take a stack which will store value ,index  --->greater bghayh ahe
//tc--->2n  sc-->n

class StockSpanner {
    private Stack<int[]> stack; // stack will store pairs (price, index)
    private int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }

    public int next(int price) {
        index++; // increase index for each new stock price

        // pop the stack until the top has a price greater than the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        // if the stack is empty, that means no greater price to the left, so span is (index + 1)
        // otherwise, span is the difference between the current index and the index of the last higher price
        int span = (stack.isEmpty()) ? (index + 1) : (index - stack.peek()[1]);

        // push the current price and index to the stack
        stack.push(new int[]{price, index});

        return span;
    }
}


