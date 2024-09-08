package Linkedlist.singlyLL;

public class InsertnodeinLLhead {
    static class Node {
        int data;      // Data stored in the node
        Node next;     // Reference to the next node in the list

        // Constructor with both data and next node as parameters
        Node(int data1, Node next1) {
            this.data = data1;
            this.next = next1;
        }

        // Constructor with only data as a parameter, sets next to null
        Node(int data1) {
            this.data = data1;
            this.next = null;
        }
    }
    public static Node convert(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp=new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    //insert at head--->create new node add data and return new head which store in temp
    // Method to insert a node at the head of the linked list
    public static Node insertNodeAtHead(Node head, int value) {
        return new Node(value, head); // Create a new node and return it as the new head
    }


    //insert at tail -->where temp.next==null there add new node and add value and ask temp to point
    public static Node insertNodeAtTail(Node head, int value) {
        if(head==null) return new Node(value);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newnode=new Node(value);
        temp.next=newnode;
        return head;
    }

    //insertat kth
    public static Node insertNodeAtkth(Node head, int element,int k) {
        if(head==null){
            if(k==1){
                return new Node(element);
            }
            else{
                return head;
            }
        }//first position vr insert
        if(k==1){
            return new Node(element, head);
        }
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==(k-1)){
                Node insertingnode =new Node(element,temp.next);
                temp.next=insertingnode;
                break;
            }
            temp=temp.next;

        }
        return head;
    }

    //insert element before the value x --->x=5 element=10
    public static Node insertNodeAtValue(Node head, int element, int value) {
        if (head == null) {
            return null;
        }

        // If the head node is the one to insert after
        if (head.data == element) {
            Node newNode = new Node(value, head.next);
            head.next = newNode;
            return head;
        }

        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data == element) {
                Node newNode = new Node(value, temp.next);
                temp.next = newNode;
                return head;
            }
            temp = temp.next;
        }

        return head;
    }

    // Method to print the entire linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        Node head = convert(arr);
     //   System.out.println("Head node data: " + head.data); // Output: 2

//        head = insertNodeAtHead(head, 100);
//        printList(head); // Output: 100 2 5 8 7

//        head = insertNodeAtTail(head, 100);
//        printList(head); // Output: 2 5 8 7 100
//
//          head = insertNodeAtkth(head, 100 ,3);
//          printList(head); // Output: 2 5 100 8 7

        head = insertNodeAtValue(head, 8, 100);
        printList(head); // Output: 2 5 100 8 7

    }
}
