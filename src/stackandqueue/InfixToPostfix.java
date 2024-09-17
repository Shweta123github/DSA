package stackandqueue;
import java.util.Stack;

//operator asel tr stack and operant asel tr answer
//jr priority top operatot peksha jast asel trch satck mdhe add otherwise pop top elemnt and add in answer and push in stack
//close bracket i mdhe disl ki sign mdhl closing bracket mdghl ans mdhe ghaych sagl leaving opening bracket and backi stack mdhe
//rahilel pop kr
public class InfixToPostfix {

        // A utility function to return
        // precedence of a given operator
        // Higher returned value means
        // higher precedence
        static int Prec(char ch) {
            switch (ch) {
                case '+':
                case '-':
                    return 1;

                case '*':
                case '/':
                    return 2;

                case '^':
                    return 3;
            }
            return -1;
        }
        static String infixToPostfix(String exp) {
            // initializing empty String for result
            String result = new String("");

            // initializing empty stack
            Stack < Character > stack = new Stack < > ();

            for (int i = 0; i < exp.length(); ++i) {
                char c = exp.charAt(i);

                // If the scanned character is an
                // operand, add it to output.
                if (Character.isLetterOrDigit(c))
                    result += c;

                    // If the scanned character is an '(',
                    // push it to the stack.
                else if (c == '(')
                    stack.push(c);

                    // If the scanned character is an ')',
                    // pop and output from the stack
                    // until an '(' is encountered.
                else if (c == ')') {
                    while (!stack.isEmpty() &&
                            stack.peek() != '(')
                        //ans mdhe ad kr
                        result += stack.pop();
                    //delete as well
                    stack.pop();
                } else // an operator is encountered
                {
                    //priority less
                    while (!stack.isEmpty() && Prec(c) <=
                            Prec(stack.peek())) {

                        result += stack.pop();
                    }
                    stack.push(c);
                }

            }

            // pop all the operators from the stack and all to result
            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "Invalid Expression";
                result += stack.pop();
            }
            return result;
        }
        public static void main(String[] args) {
            String exp = "(p+q)*(m-n)";
            System.out.println("Infix expression: " + exp);
            System.out.println("Prefix expression: " + infixToPostfix(exp));
        }
    }
//    Output:
//    Infix expression: (p+q)*(m-n)
//    Prefix expression: pq+mn-*
//    Time Complexity: O(N)
//    Space Complexity: O(N) for using the stack


/*
a+b*(c^d-e)
i   stack   answer
a            a
+   +        a
b            ab
*   +*       ab
(   +*(      ab
c            abc
^   +*(^     abc
d            abcd
-(low) +*(   abcd^
e            abcd^e
)       +*   abcd^e

abcd^e-*+



 */
