package Linkedlist.singlyLL.oddeven;

//space reduce
//play with links now
//tc-->n sc--->1
public class oddevenoptimal {

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

    public static Node rearrangeOddEven(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        //connection ahe he odd to even ch
        odd.next = evenHead;
        return head;
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Call the function to rearrange nodes
        Node result = rearrangeOddEven(head);

        // Print the rearranged list
        printList(result);//1 3 5 5 4

    }

}