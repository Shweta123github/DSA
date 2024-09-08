package Linkedlist.singlyLL.oddeven;
import java.util.ArrayList;
import java.util.List;

//group even
//group odd
//then replace it

//brute tc--->2n  sc-->n(using ext. array)
public class oddevenLL {
    static class Node {
        int data;         // Data stored in the node
        Node next;        // Reference to the next node in the linked list

        // Constructor
        public Node(int data1, Node next1) {
            this.data = data1;
            this.next = next1;
        }

        // Constructor
        public Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }
    public Node rearrangeOddEven(Node head) {
        if (head == null) {
            return head;
        }

        List<Integer> arr = new ArrayList<>();
        Node temp = head;

        // Odd position nodes
        while (temp != null && temp.next != null) {
            arr.add(temp.data);
            temp = temp.next.next;
        }

        // For the last odd node (if exists)
        if (temp != null) {
            arr.add(temp.data);
        }

        // Even position nodes
        temp = head.next;
        while (temp != null && temp.next != null) {
            arr.add(temp.data);
            temp = temp.next.next;
        }

        // For the last even node (if exists)
        if (temp != null) {
            arr.add(temp.data);
        }

        // Replace original list data with reordered values
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        printList(head);

        oddevenLL solution = new oddevenLL();
        head = solution.rearrangeOddEven(head);

        System.out.println("List after rearranging odd and even positions:");
        printList(head);
    }
}

//Original list: 1 2 3 4 5
//List after rearranging odd and even positions: 1 3 5 2 4


