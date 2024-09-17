package stackandqueue;
import java.util .*;

public class ImplementQueueusingLinkedList {


    class QueueNode {
        int val;
        QueueNode next;

        QueueNode(int data) {
            val = data;
            next = null;
        }
    }


    class Queue {
        QueueNode Front = null, Rear = null;
        int size = 0;

        boolean Empty() {
            return Front == null;
        }

        int Peek() {
            if (Empty()) {
                System.out.println("Queue is Empty");
                return -1;
            } else
                return Front.val;
        }

        void Enqueue(int value) {
            QueueNode Temp;
            Temp = new QueueNode(value);
            if (Temp == null)  //When heap exhausted
                System.out.println("Queue is Full");
            else {
                //ankhi elemnt nahi queue mdhe so start and end la temp vr ja mhnl
                if (Front == null) {
                    Front = Temp;
                    Rear = Temp;
                } //element ahet
                else {
                    Rear.next = Temp;
                    Rear = Temp;
                }
                System.out.println(value + " Inserted into Queue ");
                size++;
            }
        }

        void Dequeue() {
            if (Front == null)
                System.out.println("Queue is Empty");
            else {
                System.out.println(Front.val + " Removed From Queue");
                QueueNode Temp = Front;
                Front = Front.next;
                size--;
            }
        }

        public void main(String args[]) {
            Queue Q = new Queue();
            Q.Enqueue(10);
            Q.Enqueue(20);
            Q.Enqueue(30);
            Q.Enqueue(40);
            Q.Enqueue(50);
            Q.Dequeue();
            System.out.println("The size of the Queue is " + Q.size);
            System.out.println("The Peek element of the Queue is " + Q.Peek());
        }
    }
}


//10 Inserted into Queue
//20 Inserted into Queue
//30 Inserted into Queue
//40 Inserted into Queue
//50 Inserted into Queue
//10 Removed From Queue
//    The size of the Queue is 4
//    The Peek element of the Queue is 20
//
//    Time complexity: O(1).
//
//    Space Complexity: O(1)

