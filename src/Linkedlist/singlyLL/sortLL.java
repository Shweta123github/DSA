package Linkedlist.singlyLL;
import java.util.*;

//brute--> tc-->O(N) + O(N log N) + O(N)   sc--->n
public class sortLL {
   static class Node {
        // Data stored in the node
        int data;

        // Pointer to the next node in the list
        Node next;

        // Constructor with both data and
        // next node as parameters
        Node(int data1, Node next1) {
            data = data1;
            next = next1;
        }

        // Constructor with only data as a
        // parameter, sets next to null
        Node(int data1) {
            data = data1;
            next = null;
        }
    }



        public static Node sortLL(Node head){
            // Create a list to
            // store node values
            List<Integer> arr = new ArrayList<>();
            Node temp = head;
            while(temp != null){
                arr.add(temp.data);
                temp = temp.next;
            }
            Collections.sort(arr);

            // Reassign sorted values to
            // the linked list nodes
            temp = head;
            for(int i = 0; i < arr.size(); i++){
                temp.data = arr.get(i);
                temp = temp.next;
            }
            return head;
        }

        // Function to print the linked list
        public static void printLinkedList(Node head) {
            Node temp = head;
            while (temp != null) {
                // Print the data of the current node
                System.out.print(temp.data + " ");
                // Move to the next node
                temp = temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Linked List: 3 2 5 4 1
            Node head = new Node(3);
            head.next = new Node(2);
            head.next.next = new Node(5);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(1);

            System.out.print("Original Linked List: ");
            printLinkedList(head);

            // Sort the linked list
            head = sortLL(head);

            System.out.print("Sorted Linked List: ");
            printLinkedList(head);
        }
    }

//optimal --->use any one of it merge and quick
//break from middle
//tc-->nlog n sc-->1

// Function to merge two sorted linked lists

 /*Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
    // Create a dummy node to serve
    // as the head of the merged list
    Node dummyNode = new Node(-1);
    Node temp = dummyNode;

    // Traverse both lists simultaneously
    while (list1 != null && list2 != null) {
        // Compare elements of both lists and
        // link the smaller node to the merged list
        if (list1.data <= list2.data) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        // Move the temporary pointer
        // to the next node
        temp = temp.next;
    }

    // If any list still has remaining
    // elements, append them to the merged list
    if (list1 != null) {
        temp.next = list1;
    } else {
        temp.next = list2;
    }
    // Return the merged list starting
    // from the next of the dummy node
    return dummyNode.next;
}

// Function to find the middle of a linked list
Node findMiddle(Node head){

    if (head == null || head.next == null) {
        return head;
    }

    // Initializing slow and fast pointers
    Node slow = head;
    Node fast = head.next;

    // Move the fast pointer twice
    // as fast as the slow pointer
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // When the fast pointer reaches the end,
    // the slow pointer will be at the middle
    return slow;
}

// Function to perform merge sort on a linked list
Node sortLL(Node head){

    if (head == null || head.next == null) {
        return head;
    }


    Node middle = findMiddle(head);

    // Divide the list into two halves
    Node right = middle.next;
    middle.next = null;
    Node left = head;

    // Recursively sort the left and right halves
    left = sortLL(left);
    right = sortLL(right);

    // Merge the sorted halves using the
    // mergeTwoSortedLinkedLists function
    return mergeTwoSortedLinkedLists(left, right);
}

*/
