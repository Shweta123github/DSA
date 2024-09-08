package Linkedlist.singlyLL;
import java.util.*;

//brute
//for even -->we return second middle
//n/2+1 --.middle
//tc--->O(N+N/2)   sc--->1
public class MiddleelementofLL {


    // Node class represents a node in a linked list
  /*  static  class Node {
        // Data stored in the node
        int data;
        // Pointer to the next node in the list
        Node next;

        // Constructor with both data
        // and next node as parameters
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class FindMiddleOfLinkedList {

        // Function to find the middle node of a linked list
        static Node findMiddle(Node head) {
            // If the list is empty or has
            // only one element, return the head as
            // it's the middle.
            if (head == null || head.next == null) {
                return head;
            }

            Node temp = head;
            int count = 0;

            // Count the number of nodes
            // in the linked list.
            while (temp != null) {
                count++;
                temp = temp.next;
            }

            // Calculate the position of the middle node.
            int mid = count / 2 + 1;
            temp = head;

            while (temp != null) {
                mid--;

                // Check if the middle
                // position is reached.
                if (mid == 0){
                    // break out of the loop
                    // to return temp
                    break;
                }
                // Move temp ahead
                temp = temp.next;
            }

            // Return the middle node.
            return temp;
        }

        public static void main(String[] args) {
            // Creating a sample linked list:
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            // Find the middle node
            Node middleNode = findMiddle(head);

            // Display the value of the middle node
            System.out.println("The middle node value is: " + middleNode.data);
        }
    }//3
}
*/

//optimal -->tottisehare method
//slow by one step
//fast by two step   fast jevha last node vr asel tevha slow mid vr asty so tithch stop-->for odd
//for even -->fast reches to null tith stop
//tc---> O(N/2)   sc--->1


// Node class represents a node in a linked list
static class Node {
    // Data stored in the node
    int data;
    // Pointer to the next node in the list
    Node next;

    // Constructor with both data
    // and next node as parameters
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


    static Node findMiddle(Node head) {
        // Initialize the slow pointer to the head.
        Node slow = head;

        // Initialize the fast pointer to the head.
        Node fast = head;

        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null && slow != null) {
            // Move fast two steps.
            fast = fast.next.next;
            // Move slow one step.
            slow = slow.next;
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow;
    }


    public static void main(String[] args) {
        // Creating a sample linked list:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Find the middle node
        Node middleNode = findMiddle(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.data);
    }
}

