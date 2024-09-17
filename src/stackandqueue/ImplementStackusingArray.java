package stackandqueue;
import java.util.*;

//disadvantage -->as me 3 element push kel and taysathi 10000 evdh moth array create kel so baki ch array tr empty ch
//rahil n

public class ImplementStackusingArray {

        public void main(String[] args) {

            stack s = new stack();
            s.push(6);
            s.push(3);
            s.push(7);
            System.out.println("Top of the stack before deleting any element " + s.top());
            System.out.println("Size of the stack before deleting any element " + s.size());
            System.out.println("The element deleted is " + s.pop());
            System.out.println("Size of the stack after deleting an element " + s.size());
            System.out.println("Top of the stack after deleting an element " + s.top());
        }
    }
    class stack {
        int size = 10000;
        int arr[] = new int[size];
        int top = -1;

        void push(int x) {
            top++;
            arr[top] = x;
        }
        int pop() {
            int x = arr[top];
            top--;
            return x;
        }
        int top() {
            return arr[top];
        }
        int size() {
            return top + 1;
        }
    }
//
//    Top of the stack before deleting any element 7
//    Size of the stack before deleting any element 3
//    The element deleted is 7
//    Size of the stack after deleting an element 2
//    Top of the stack after deleting an element 3
//
//    Time Complexity: O(N)
//    Space Complexity: O(N)

