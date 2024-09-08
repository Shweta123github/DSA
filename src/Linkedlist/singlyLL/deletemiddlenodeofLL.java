package Linkedlist.singlyLL;
import java.util.*;

//brute-->n+n/2  sc-->1
public class deletemiddlenodeofLL {



    // Node class represents a node in a linked list
  static   class Node {
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
        // Function to delete the
        // middle node of a linked list
        public static Node deleteMiddle(Node head) {
            // Initialize a temporary node
            // to traverse the linked list
            Node temp = head;

            // Variable to hold the number
            // of nodes in the linked list
            int n = 0;

            // Loop to count the number of
            // nodes in the linked list
            while (temp != null) {
                n++;
                temp = temp.next;
            }

            // Calculate the index of the middle node
            int res = n / 2;

            // Reset the temporary node to
            // the beginning of the linked list
            temp = head;

            // Loop to find the
            // middle node to delete
            while (temp != null) {

                res--;

                // If the middle node is found
                if (res == 0) {

                    // Create a pointer
                    // to the middle node
                    Node middle = temp.next;

                    // Adjust pointers to
                    // skip the middle node
                    temp.next = temp.next.next;

                    // No need to explicitly free memory in Java,
                    // as it's managed by the garbage collector

                    // Exit the loop after
                    // deleting the middle node
                    break;
                }
                // Move to the next node
                // in the linked list
                temp = temp.next;
            }
            // Return the head of the
            // modified linked list
            return head;
        }


        static void printLL(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {


            // Creating a sample linked list:
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);

            // Display the original linked list
            System.out.print("Original Linked List: ");
            printLL(head);

            // Deleting the middle node
            head = deleteMiddle(head);

            // Displaying the updated linked list
            System.out.print("Updated Linked List: ");
            printLL(head);
        }
    }
//Original Linked List: 1 2 3 4 5
//Updated Linked List: 1 2 4 5

//optimal --->tc--->n sc-->1 tottoise and here

//static Node deleteMiddle(Node head) {

//    if (head == null || head.next == null) {
//        return null;
//    }
//
//    // Initialize slow and fast pointers
//    Node slow = head;
//    Node fast = head;
//slow la move nahi kel only fast nantrch step mdhe kel ahe doghama move
//    fast = head.next.next;
//
//    // Move 'fast' pointer twice as fast as 'slow'
//    while (fast != null && fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//    }
//
//    // Delete the middle node by skipping it
//    if (slow.next != null) {
//        slow.next = slow.next.next;
//    }
//    return head;
//}

