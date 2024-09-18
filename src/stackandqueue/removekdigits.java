package stackandqueue;
import java.util.Stack;


//remove k get smallest possible number-->1219
//remove larger number so will get small no.
//edge cases--> if k==n return 0
//if having number like 00100 ---.remove starting zeros
//if having number like 123456 and k=3  --->yayt saglch valid ahe jr kahich remove hoat nsel tr last che remove kr
//tc--->2n+k   sc--->2n
public class removekdigits {

        public String removeKdigits(String num, int k) {

            int len=num.length();

            if(k==len)
            {
                return "0";
            }

            Stack<Character>stack = new Stack<>();

            for(int i=0;i<len;i++)
            {
                //stack ch top elemnt greater asel tr tayla pop and k-- otherwise push
                while(k>0 &&!stack.isEmpty() && stack.peek()>num.charAt(i))
                {
                    stack.pop();
                    k--;
                }

                stack.push(num.charAt(i));


            }

            //suppose after ierating num if still k >0 do poping
            while(k>0)
            {
                stack.pop();
                k--;
            }


// stack mdhun pop krat ahe final elements
            StringBuilder result = new StringBuilder();

            while(!stack.isEmpty())
            {
                result.append(stack.pop());

            }


            //tayna reverse
            result.reverse();

        //Remove Leading Zeros
            while(result.length()>1 && result.charAt(0)=='0')
            {
                result.deleteCharAt(0);
            }

            return result.toString();

        }
    }