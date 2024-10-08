package stackandqueue;

//disadvantage --->we want constant size  so to overcame this issue we have LL
public class ImplementQueueUsingArray {

    class Queue {

        private int arr[];
        private int start, end, currSize, maxSize;

        public Queue() {
            arr = new int[16];
            start = -1;
            end = -1;
            currSize = 0;
        }

        public Queue(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            start = -1;
            end = -1;
            currSize = 0;
        }

        public void push(int newElement) {
            if (currSize == maxSize) {
                System.out.println("Queue is full\nExiting...");
                System.exit(1);
            }
            //currsize==0 start and end la 0 la point kr mhnl
            if (end == -1) {
                start = 0;
                end = 0;
            }
            //(currsize!=0)
            else
                end = (end + 1) % maxSize;
            arr[end] = newElement;
            System.out.println("The element pushed is " + newElement);
            //element add kel and currsizr increased
            currSize++;
        }

        public int pop() {
            if (start == -1) {
                System.out.println("Queue Empty\nExiting...");
                System.exit(1);
            }
            int popped = arr[start];
            //we destroying queuq and going back to original
            if (currSize == 1) {
                start = -1;
                end = -1;
            } else
                start = (start + 1) % maxSize;
            currSize--;
            return popped;
        }

        public int top() {
            if (start == -1) {
                System.out.println("Queue is Empty");
                System.exit(1);
            }
            return arr[start];
        }

        public int size() {
            return currSize;
        }

    }

        public void main(String args[]) {
            Queue q = new Queue(6);
            q.push(4);
            q.push(14);
            q.push(24);
            q.push(34);
            System.out.println("The peek of the queue before deleting any element " + q.top());
            System.out.println("The size of the queue before deletion " + q.size());
            System.out.println("The first element to be deleted " + q.pop());
            System.out.println("The peek of the queue after deleting an element " + q.top());
            System.out.println("The size of the queue after deleting an element " + q.size());
        }
    }


//    The element pushed is 4
//    The element pushed is 14
//    The element pushed is 24
//    The element pushed is 34
//    The peek of the queue before deleting any element 4
//    The size of the queue before deletion 4
//    The first element to be deleted 4
//    The peek of the queue after deleting an element 14
//    The size of the queue after deleting an element 3

//    Time Complexity:
//    pop function: O(1)
//    push function: O(1)
//    top function: O(1)
//    size function: O(1)


