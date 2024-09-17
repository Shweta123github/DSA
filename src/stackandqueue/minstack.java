package stackandqueue;

//min value from stack
//yayt stack mdhe aapn value ani min store krat ahet only
//compare krat ahot min nsel tr push asel tr answer
/*public class minstack {

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    class MinStack {
        Stack < Pair > st;
        public MinStack() {
            st = new Stack < > ();
        }

        public void push(int x) {
            int min;
            if (st.isEmpty()) {
                min = x;
            } else {
                min = Math.min(st.peek().y, x);
            }
            st.push(new Pair(x, min));
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek().x;
        }

        public int getMin() {
            return st.peek().y;
        }
    }


//    Time Complexity: O(1)
//    Space Complexity: O(2N)
}
*/

//optimal -->we cant store 2 element in stack we want 1 now
//whenever we'll get min we are not adding in stack instead we are doing modified value like 2*val-prevmin=new value
//and replacing min to actual value
//again back to min jaat ahe because we want 2 min

//    Stack < Long > st = new Stack < Long > ();
//    Long mini;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        mini = Long.MAX_VALUE;
//    }
//
//    public void push(int value) {
//        Long val = Long.valueOf(value);
//        if (st.isEmpty()) {
//            mini = val;
//            st.push(val);
//        } else {
//            if (val < mini) {
//                st.push(2 * val - mini);
//                mini = val;
//            } else {
//                st.push(val);
//            }
//        }
//    }
//
//    //second prev min
//    public void pop() {
//        if (st.isEmpty()) return;
//
//        Long val = st.pop();
//        if (val < mini) {
//            mini = 2 * mini - val;
//        }
//    }
//
//    public int top() {
//        Long val = st.peek();
//        if (val < mini) {
//            return mini.intValue();
//        }
//        return val.intValue();
//    }
//
//    public int getMin() {
//        return mini.intValue();
//    }
//}
//Time Complexity: O(1)
//Space Complexity: O(N)