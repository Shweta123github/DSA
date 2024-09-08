package Linkedlist.DoublyLL;

public class InsertionDLL {
    class Node {
        public int data;       // Data stored in the node
        public Node next;      // Reference to the next node in the list (forward direction)
        public Node back;      // Reference to the previous node in the list (backward direction)

        // Constructor for a Node with data, next, and back references
        public Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        // Constructor for a Node with only data
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

    // Method to insert a node before the head
    public Node insertbeforehead2(Node head, int value) {
        Node newhead = new Node(value, head, null);
        head.back = newhead;
        return newhead; // Return the new head
    }
    //insert  before tail
    public Node insertbeforetail2(Node head, int value) {

        if(head.next==null){
            return insertbeforehead2(head,value);
        }
        Node temp=head;
        while(temp.next!=null){
            temp=  temp.next;

        }
        Node prev=temp.back;
        Node newnode=new Node(value,temp,prev);
        prev.next=newnode;
        temp.back=newnode;
        return head;
    }

    //insert at kth
    public Node insertatkth(Node head, int k ,int value) {

        if(k==1){
            return insertbeforehead2(head,value);
        }
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==k) break;
            temp=  temp.next;

        }
        Node prev=temp.back;
        Node newnode=new Node(value,temp,prev);
        prev.next=newnode;
        temp.back=newnode;
        return head;
    }

    public static void main(String[] args) {
        InsertionDLL list = new InsertionDLL();  // Create an instance of InsertionDLL
        int[] arr = {2, 5, 8, 7};
        Node head = list.convert2(arr);

//        head = list.insertbeforehead2(head, 100);
//        System.out.println("List after inserting given value before:"); // 100 2 5 8 7

//            head = list.insertbeforetail2(head, 100);
//        System.out.println("List after inserting given value before:"); // 2 5 8 100 7

//            head = list.insertatkth(head, 3,100);
//            System.out.println("List after inserting given value before:");

            Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // Expected output: 2 5 8 7
            temp = temp.next;
        }
    }
}