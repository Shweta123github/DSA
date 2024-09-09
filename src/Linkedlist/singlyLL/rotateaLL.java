package Linkedlist.singlyLL;
import java.util.*;

//last ch element pudh yet and baki right la sarakat
//if its multiple of given length dont do anything because we'll get same list as before so directly return the head
//if length=13  -->then we can do that 5+5+3  only for 3 time rotate
//length and tail required
//tc--->n*k   sc-->1
public class rotateaLL {
   static class Node {
        int num;
        Node next;
        Node(int a) {
            num = a;
            next = null;
        }
    }
        //utility function to insert node at the end of the list
        static Node insertNode(Node head, int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                return head;
            }
            Node temp = head;
            while (temp.next != null) temp = temp.next;

            temp.next = newNode;
            return head;
        }


    static Node findNthNode(Node temp, int k) {
        int count = 1;
        while (temp != null) {
            if (count == k) return temp;
            count++;
            temp = temp.next;
        }
        return temp; // This will return null if k is greater than the list length
    }

    // Method to rotate the linked list to the right by k places
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Calculate length of the linked list
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // If k is a multiple of length, no rotation is needed
        if (k % length == 0) return head;

        // Adjust k to avoid unnecessary rotations
        k = k % length;

        // Attach the tail to the head to form a circular list
        tail.next = head;

        // Find the new last node
        Node newLastNode = findNthNode(head, length - k);

        // Set the new head and break the cycle
        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }

    //utility function to print list
        static void printList(Node head) {
            while (head.next != null) {
                System.out.print(head.num + "->");
                head = head.next;
            }
            System.out.println(head.num);

        }

        public static void main(String args[]) {
            Node head = null;
            //inserting Node
            head = insertNode(head, 1);
            head = insertNode(head, 2);
            head = insertNode(head, 3);
            head = insertNode(head, 4);
            head = insertNode(head, 5);

            System.out.println("Original list: ");
            printList(head);

            int k = 2;
            Node newHead = rotateRight(head, k); //calling function for rotating right of the nodes by k times

            System.out.println("After " + k + " iterations: ");
            printList(newHead); //list after rotating nodes

        }
    }
//Original list:
//        1->2->3->4->5
//After 2 iterations:
//        4->5->1->2->3

