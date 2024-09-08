package Linkedlist.sortby012;

//change links one pass solution
// tc-->n  sc-->1
public class optimal {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedListSorter {

        public static Node sortLinkedList(Node head) {
            if (head == null || head.next == null) return head;

            Node zeroHead = new Node(-1);
            Node oneHead = new Node(-1);
            Node twoHead = new Node(-1);

            Node zero = zeroHead;
            Node one = oneHead;
            Node two = twoHead;
            Node temp = head;

            while (temp != null) {
                if (temp.data == 0) {
                    zero.next = temp;
                    zero = temp;
                } else if (temp.data == 1) {
                    one.next = temp;
                    one = temp;
                } else {
                    two.next = temp;
                    two = temp;
                }
                temp = temp.next;
            }

            // Connect the end of zero list to the head of the one list, and end of one list to the head of the two list
            zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
            one.next = twoHead.next;
            two.next = null;
           // newhead=zeroHead.next;

            return zeroHead.next;
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
            // Creating a linked list with nodes having values 2, 0, 1, 0, 1
            Node head = new Node(2);
            head.next = new Node(0);
            head.next.next = new Node(1);
            head.next.next.next = new Node(0);
            head.next.next.next.next = new Node(1);

            System.out.println("Original List:");
            printList(head);

            head = sortLinkedList(head);

            System.out.println("Sorted List:");
            printList(head);
        }
    }
}
//Original List: 2 0 1 0 1
//Sorted List: 0 0 1 1 2
