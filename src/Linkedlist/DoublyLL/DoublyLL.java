package Linkedlist.DoublyLL;
//concept used in browser
public class DoublyLL {
    class Node {
        public int data;       // Data stored in the node
        public Node next;      // Reference to the next node in the list (forward direction)
        public Node back;      // Reference to the previous node in the list (backward direction)

        // Constructor for a Node with both data, a reference to the next node, and a reference to the previous node
        public Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        // Constructor for a Node with data, and no references to the next and previous nodes (end of the list)
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    // Method to convert an array to a doubly linked list
    public Node convert2(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            temp.back = mover;  // Set the backward link
            mover = temp;
        }
        return head;
    }

    // Deletion of head
    private static Node removehead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        head = head.next;

        head.back = null;
        temp.next = null;

        return head;
    }

    // Deletion of tail
    private static Node removetail(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newtail = temp.back;
        if (newtail != null) {
            newtail.next = null;
        }
        temp.back = null;
        return head;
    }

    // Delete kth node
    public static Node removek(Node head, int k) {
        // Edge cases
        if (head == null || k <= 0) return null;

        int count = 1;
        Node temp = head;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (temp == null) return head;  // k is greater than the number of nodes

        Node prev = temp.back;
        Node next = temp.next;

        // If k-th node is the head
        if (prev == null) {
            return removehead(head);
        }

        // If k-th node is the tail
        if (next == null) {
            return removetail(head);
        }

        // For k-th node in the middle
        prev.next = next;
        next.back = prev;

        //cut temp
        temp.next = null;
        temp.back = null;

        return head;
    }

    //delete node based on value
    public static Node removeByValue(Node head, int value) {
        if (head == null) return null;

        Node temp = head;

        while (temp != null) {
            if (temp.data == value) {  // Found the node with the given value
                Node prev = temp.back;
                Node next = temp.next;

                // If the node to delete is the head
                if (prev == null) {
                    return removehead(head);
                }

                // If the node to delete is the tail
                if (next == null) {
                    return removetail(head);
                }

                // If the node is in the middle connect kraych
                prev.next = next;
                next.back = prev;

                temp.next = null;
                temp.back = null;

                return head;
            }
            temp = temp.next;
        }

        // Return the head if no node with the value is found
        return head;
    }

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();  // Create an instance of DoublyLL
        int[] arr = {2, 5, 8, 7};
        Node head = list.convert2(arr);


//        //remove head
//        head = removehead(head);
//        System.out.println("List after removing head node: ");//5 8 7

//        //remove tail
//        head = removetail(head);
//        System.out.println("List after removing tail node: ");//2 5 8

//        //kth index based
//        head = removek(head,2);
//        System.out.println("List after removing kth: ");//2 5 7

        //value based
//        head = removeByValue(head, 8);   // Remove the node with value 8
//        System.out.println("List after removing node with value 8: ");// 2 5 7


        // Traversing and printing the linked list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // Expected output: 2 5 8 7
            temp = temp.next;
        }

    }
}