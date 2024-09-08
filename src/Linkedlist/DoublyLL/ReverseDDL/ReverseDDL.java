package Linkedlist.DoublyLL.ReverseDDL;
import java.util.Stack;

//reverse DDL and return new head
//brute-->use stack to add  elements and then replace it with poping the stack tc-->O(2N)  sc-->n as we using stack


public class ReverseDDL {

    public static class DLinkedList {
        public static class Node {
            // Data stored in the node
            public int data;
            // Reference to the next node (forward direction)
            public Node next;
            // Reference to the previous node (backward direction)
            public Node back;

            // Constructor for a Node with data, next node, and previous node
            public Node(int data1, Node next1, Node back1) {
                data = data1;
                next = next1;
                back = back1;
            }

            // Constructor for a Node with data only
            public Node(int data1) {
                data = data1;
                next = null;
                back = null;
            }
        }

       public static Node convertArr2DLL(int[] arr) {
            // Create the head node with the first element of the array
            Node head = new Node(arr[0]);
            // Initialize 'prev' to the head node
            Node prev = head;

            for (int i = 1; i < arr.length; i++) {
                // Create a new node and set its 'back' pointer to the previous node
                Node temp = new Node(arr[i], null, prev);
                // Update the 'next' pointer of the previous node to point to the new node
                prev.next = temp;
                // Move 'prev' to the newly created node
                prev = temp;
            }
            return head; // Return the head of the doubly linked list
        }

        public static void print(Node head) {
            while (head != null) {
                // Print the data in the current node
                System.out.print(head.data + " ");
                // Move to the next node
                head = head.next;
            }
            System.out.println();
        }

        public static Node reverseDLL(Node head) {
            // Initialise a stack to store node data
            Stack<Integer> st = new Stack<>();

            // Traverse the doubly linked list and push node data into the stack
            Node temp = head;
            while (temp != null) {
                st.push(temp.data);
                temp = temp.next;
            }

            // Reinitialise temp to head and replace node data from the stack
            temp = head;
            while (temp != null) {
                temp.data = st.pop();
                temp = temp.next;
            }

            // Return the updated doubly linked list with reversed values
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        // Convert the array to a doubly linked list
        DLinkedList.Node head = DLinkedList.convertArr2DLL(arr);

        // Print the initial doubly linked list
        System.out.println("Doubly Linked List Initially:");
        DLinkedList.print(head);

        // Reverse the doubly linked list
        System.out.println("Doubly Linked List After Reversing:");
        head = DLinkedList.reverseDLL(head);
        DLinkedList.print(head);
    }
}
//Doubly Linked List Initially:
//        12 5 6 8 4
//Doubly Linked List After Reversing:
//        4 8 6 5 12


