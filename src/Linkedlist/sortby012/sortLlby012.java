package Linkedlist.sortby012;
//return head
//data replace
//brute--->tc-->2n   sc--->1
public class sortLlby012 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        public static void sortLinkedList(Node head) {
            Node temp = head;
            int count0 = 0;
            int count1 = 0;
            int count2 = 0;

            // Count occurrences of 0s, 1s, and 2s
            while (temp != null) {
                if (temp.data == 0) count0++;
                else if (temp.data == 1) count1++;
                else count2++;

                temp = temp.next;
            }

            // Update the list with sorted values
            temp = head;
            while (temp != null) {
                if (count0 > 0) {
                    temp.data = 0;
                    count0--;
                } else if (count1 > 0) {
                    temp.data = 1;
                    count1--;
                } else {
                    temp.data = 2;
                    count2--;
                }
                temp = temp.next;
            }
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

            Node head = new Node(1);
            head.next = new Node(0);
            head.next.next = new Node(2);
            head.next.next.next = new Node(1);
            head.next.next.next.next = new Node(2);
            head.next.next.next.next.next = new Node(0);

            System.out.println("Original List:");
            printList(head);

            sortLinkedList(head);

            System.out.println("Sorted List:");
            printList(head);
        }
    }
//Original List: 1 0 2 1 2 0
//Sorted List: 0 0 1 1 2 2

