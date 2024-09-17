package stackandqueue;
import java.util.*;

//s1-->s2
//add x to -->s1
//s2--->s1
//limited push --->use approch 1
//more push -->use approch 2  means push optimize krat ahet

//approch 1
public class ImplementQueueusingStack {

    class MyQueue {
        Stack < Integer > s1 = new Stack < > ();
        Stack < Integer > s2 = new Stack < > ();
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (s1.empty() == false) {
                //s1-->s2
                s2.push(s1.peek());
                s1.pop();
            }
            // Insert the desired element in the stack input
            System.out.println("The element pushed is " + x);
            //x add to s1
            s1.push(x);
            // Pop out elements from the stack output and push them into the stack input
            while (s2.empty() == false) {
                //s2-->s1
                s1.push(s2.peek());
                s2.pop();
            }

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            // shift input to output
            if (s1.empty()) {
                System.out.println("Stack is empty");

            }
            int val = s1.peek();
            s1.pop();
            return val;

        }

        /** Get the front element. */
        public int peek() {
            // shift input to output
            if (s1.empty()) {
                System.out.println("Stack is empty");

            }
            return s1.peek();
        }


        int size() {
            return s1.size();
        }
    }
        public  void main(String args[]) {
            MyQueue q = new MyQueue();
            q.push(3);
            q.push(4);
            System.out.println("The element poped is " + q.pop());
            q.push(5);
            System.out.println("The top element is " + q.peek());
            System.out.println("The size of the queue is " + q.size());

        }
    }
//    Output:
//
//    The element pushed is 3
//    The element pushed is 4
//    The element poped is 3
//    The element pushed is 5
//    The top element is 4
//    The size of the queue is 2
//
//    Time Complexity: O(N )
//
//    Space Complexity: O(2N)
//}

//leetcode  2 approch

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        System.out.println("The element pushed is " + x);
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     * s2.empty so simple pop
     * if not shift all s1 -->s2 and then pop
     */
    public int pop() {
        // shift input to output
        if (s2.empty())
            while (s1.empty() == false) {
                s2.push(s1.peek());
                s1.pop();
            }
        int x = s2.peek();
        s2.pop();
        return x;
    }

    /**
     * Get the front element.
     * if s2 is empty directly get peek
     * if not same as per above
     */
    public int peek() {
        // shift input to output
        if (s2.empty())
            while (s1.empty() == false) {
                s2.push(s1.peek());
                s1.pop();
            }
        return s2.peek();
    }

    int size() {
        return (s2.size() + s1.size());


    }

    public void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());

    }
}

//Output:
//
//The element pushed is 3
//The element pushed is 4
//The element poped is 3
//The element pushed is 5
//The top element is 4
//The size of the queue is 2
//
//Time Complexity: O(1 )
//
//Space Complexity: O(2N)
//
