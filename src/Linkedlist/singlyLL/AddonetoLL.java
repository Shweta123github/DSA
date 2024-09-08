package Linkedlist.singlyLL;

//tc---.3n   sc-->1
//reverse--->adding 1--->reverse to original
public class AddonetoLL {

    // Define a Node class for the linked list
   /* class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to add one to the linked list
    public Node addOne(Node head) {
        // Reverse the linked list
        head = reverse(head);
        Node temp = head;
        int carry = 1;

        // Traverse the list and add carry
        while (temp != null) {
            temp.data = temp.data + carry;

            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }

            temp = temp.next;
        }

        // If carry is still 1, add a new node at the beginning
        if (carry == 1) {
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }

        // Reverse the list back to its original order
        head = reverse(head);
        return head;
    }

    // Function to reverse the linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        Node front = null;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    // Function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddonetoLL list = new AddonetoLL();

        // Creating the linked list: 9 -> 9 -> 9
        Node head = list.new Node(9);
        head.next = list.new Node(9);
        head.next.next = list.new Node(9);

        System.out.println("Original List:");
        list.printList(head);

        // Add 1 to the linked list
        head = list.addOne(head);

        System.out.println("List after adding 1:");
        list.printList(head);
    }
}*/


//Original List: 9 9 9
//List after adding 1: 1 0 0 0

//optimal using recursion because in LL there is no backpointers thatswhy we using recursion becoz it has backtracking
//tc,sc--->n
    //iterative  --->pros(no space) cause(tampring data more time taken)
    //recursive  --->pros(no tampring of data ,addition in place and in faster time)  cause(extra space)
static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public static class LinkedList {

    // Function to add 1 to the linked list
    public Node fun(Node head) {
        //final carry
        int carry = helper(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    // Helper function to handle carry and addition
    private static int helper(Node head) {
        if (head == null) {
            return 1; // base case, propagate carry
        }

        int carry = helper(head.next); // recursive call
        head.data = head.data + carry; // add carry to current node's data

        if (head.data < 10) {
            return 0; // no further carry=0
        }

        head.data = 0; // reset to 0 if data >= 10
        return 1; // propagate carry
    }

    // Function to print the linked list
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 9 -> 9 -> 9
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);

        LinkedList list = new LinkedList();

        System.out.print("Original list: ");
        list.printList(head);

        // Add 1 to the linked list
        head = list.fun(head);

        System.out.print("Updated list after adding 1: ");
        list.printList(head);

    } }
}
