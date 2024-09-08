package Linkedlist.singlyLL.reverseLL;
import java.util.Stack;

//tc--->n   sc--->1
public class optimalreverseLL {

    // Node class represents a node in a linked list
    static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node in the list

        // Constructor with data and next node as parameters
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as a parameter, sets next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node reverseLinkedList(Node head) {
        Node temp = head;   // Initialize 'temp' at head of linked list
        Node prev = null;   // Initialize pointer 'prev' to null

        // Traverse the list, continue till 'temp' reaches the end (NULL)
        while (temp != null) {
            Node front = temp.next;  // Store the next node in 'front'
            temp.next = prev;        // Reverse the 'next' pointer of the current node
            prev = temp;             // Move 'prev' to the current node
            temp = front;            // Move 'temp' to the 'front' node
        }

        return prev; // Return the new head of the reversed linked list
    }

    // Function to print the linked list
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}