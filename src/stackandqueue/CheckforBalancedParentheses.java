package stackandqueue;
import java.util.*;

//open asel tr stack mdhe push
//closing asel tr tech stack mdhl sobat check krat ahe
//tc,sc--->n
public class CheckforBalancedParentheses {

         public static boolean isValid(String s) {
            Stack<Character> st = new Stack<Character>();
            for (char it : s.toCharArray()) {
                //if opening
                if (it == '(' || it == '[' || it == '{')
                    st.push(it);
                //closing bracket
                else {
                    if(st.isEmpty()) return false;
                    //stack mdhun pop
                    char ch = st.pop();
                    //check krnar open and close doni ahet ka --->if this is true its fine
                    if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;

                    //if not return false
                    else
                        return false;
                }
            }
            return st.isEmpty();
        }

        public static void main (String[] args) {

            String s="()[{}()]";
            if(isValid(s)==true)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
