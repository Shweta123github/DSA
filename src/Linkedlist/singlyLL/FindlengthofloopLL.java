package Linkedlist.singlyLL;
import java.util.HashMap;

//optimal---->tortoise and hare
//tc-->n sc--->1
public class FindlengthofloopLL {

    static class Node {
        int data;
        Node next;
        Node(int data1, Node next1) {
            data = data1;
            next = next1;
        }
        Node(int data1) {
            data = data1;
            next = null;
        }
    }

    // Function to return the lenght
    // of loop when slow and fast are
    // on the same node
    static int findLength(Node slow, Node fast) {
        int cnt = 1;
        //kont pn point move kr
        fast = fast.next;

        // traverse fast till it
        // reaches back to slow
        while (slow != fast) {

            // at each node increase
            // count by 1 and move fast
            // forward by one step
            cnt++;
            fast = fast.next;
        }

        // loop terminates when fast reaches
        // slow again and the count is returned
        return cnt;
    }
    static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findLength(slow, fast);
            }
        }
        // Step 3: If the fast pointer reaches the end
        // there is no loop
        return 0;
    }


    public static void main(String[] args) {
        // Create a sample linked list with a loop
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Create a loop from fifth to second
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // This creates a loop
        fifth.next = second;

        int loopLength = lengthOfLoop(head);
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}//4
