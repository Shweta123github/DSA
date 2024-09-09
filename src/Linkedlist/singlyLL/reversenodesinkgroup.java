package Linkedlist.singlyLL;
import java.util.*;

//kth node kdh--->break kr adhi and it'll point to null
//(taych adhi nextnode ch link save kr )so it will perform as individual list and then--->reverse-->last la connect kr group

//tc-->2n sc-->1
public class reversenodesinkgroup {

   static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next
        // node in the list
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
    //Reverses the entire linked list starting from head.
        static Node reverseLinkedList(Node head) {

            Node temp = head;
            Node prev = null;
            while(temp != null){
                Node front = temp.next;
                temp.next = prev;
                //point move kel ahe
                prev = temp;
                temp = front;
            }
            return prev;

        }
        static Node getKthNode(Node temp, int k) {
            while (temp != null && k > 1) {
                temp = temp.next;
                k--;
            }
            return temp;
        }

        // Reverses the linked list in groups of k nodes using the above two functions.
        static Node kReverse(Node head, int k) {
            Node temp = head;
            // last node of the previous group
            Node prevLast = null;
            while (temp != null) {
                Node kThNode = getKthNode(temp, k);

                // If the Kth node is NULL
                // (not a complete group)
                if (kThNode == null) {

                    // If there was a previous group,
                    // link the last node to the current node
                    if (prevLast != null) {
                        prevLast.next = temp;
                    }

                    // Exit the loop
                    break;
                }

                // Store the next node
                // after the Kth node
                Node nextNode = kThNode.next;

                // Disconnect the Kth node
                // to prepare for reversal
                kThNode.next = null;

                // Reverse the nodes from
                // temp to the Kth node
                reverseLinkedList(temp);

                // Adjust the head if the reversal
                // starts from the head
                if (temp == head) {
                    head = kThNode;
                } else {
                    // Link the last node of the previous
                    // group to the reversed group
                    prevLast.next = kThNode;
                }

                // Update the pointer to the
                // last node of the previous group
                prevLast = temp;

                // Move to the next group
                temp = nextNode;
            }

            // Return the head of the
            // modified linked list
            return head;
        }
        static void printLinkedList(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            Node head = new Node(5);
            head.next = new Node(4);
            head.next.next = new Node(3);
            head.next.next.next = new Node(7);
            head.next.next.next.next = new Node(9);
            head.next.next.next.next.next = new Node(2);
            System.out.print("Original Linked List: ");
            printLinkedList(head);
            head = kReverse(head, 4);
            System.out.print("Reversed Linked List: ");
            printLinkedList(head);
        }
    }
//Original Linked List: 5 4 3 7 9 2
//Reversed Linked List: 7 3 4 5 9 2
