package Linkedlist.singlyLL.reverseLL;
import java.util.Stack;


//tc-->2n sc-->n
public class ReverseLL {

    // Node class represents a node in a linked list
    static class Node {
        int data;  // Data stored in the node
        Node next; // Pointer to the next node in the list

        // Constructor with both data and next node as parameters
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

    public static class ReverseLinkedListUsingStack {

        // Function to reverse the linked list using a stack
        public static Node reverseLinkedList(Node head) {
            Node temp = head;
            Stack<Integer> stack = new Stack<>();

            // Step 1: Push the values of the linked list onto the stack
            while (temp != null) {
                stack.push(temp.data);
                temp = temp.next;
            }

            // Reset the temporary pointer to the head of the linked list
            temp = head;

            // Step 2: Pop values from the stack and update the linked list
            while (temp != null) {
                temp.data = stack.pop();
                temp = temp.next;
            }

            return head;
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
}
//Original Linked List: 1 3 2 4
//Reversed Linked List: 4 2 3 1
