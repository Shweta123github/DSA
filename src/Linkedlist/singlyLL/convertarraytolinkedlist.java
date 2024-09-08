package Linkedlist.singlyLL;

//singlyLL--->only one direction jaat magh jata yet nahi ----->
//delete kth means it can be head,tail middle
public class convertarraytolinkedlist {
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
    // Method to convert an array to a linked list
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

   private static int lenghthll(Node head){
        int count=0;
        Node temp=head;
        while(temp !=null){
            temp=temp.next;
            count++;
        }
        return count;
    }

    private static int checkifpresent(Node head,int value){
        Node temp=head;
        while(temp!=null){
            if(temp.data==value) return 1;
            temp = temp.next;
        }
        return 0;
    }
//deletion
    private static Node removehead(Node head){
        if(head==null) return head;{
            head=head.next;
            return head;
        }
    }
    private static Node removetail(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    //tc--->n
    public static Node removek(Node head, int k) {
        if (head == null) return head;

        if (k == 1) {
            return head;  // Directly return the next node to remove the head
        }

        int count = 0;  // Start count at 1 to match the position index
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            count++;
            if (count == k) {  // Check if the current node is the k-th node
                prev.next = prev.next.next;  // Skip the k-th node
                break;
            }
            prev = temp;  // Move prev to the current node
            temp = temp.next;  // Move temp to the next node
        }

        return head;
    }
//depend on value delete
public static Node removeelement(Node head, int element) {
    if (head == null) return head;

    if (head.data == element) {
        return head;  // Directly return the next node to remove the head
    }

    Node temp = head;
    Node prev = null;

    while (temp != null) {
        if (temp.data == element) {  // Check if the current node is the k-th node
            prev.next = prev.next.next;  // Skip the k-th node
            break;
        }
        prev = temp;  // Move prev to the current node
        temp = temp.next;  // Move temp to the next node
    }

    return head;
}


    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        Node head = convert(arr);
        System.out.println("Head node data: " + head.data);//2

        System.out.println(lenghthll(head));//4
        System.out.println(checkifpresent(head ,8));//1 true
//        head = removehead(head); // Remove head node
//        System.out.println("List after removing head node: ");// 5 8 7 new head is 5 now

//        head = removetail(head); // Remove head node
//        System.out.println("List after removing tail node: ");//2 5 8

        //index through
//        head = removek(head,3); // Remove head node
//        System.out.println("List after removing kth: ");//2 5 7

        //value through
        head = removeelement(head,7); // Remove head node
        System.out.println("List after removing element: ");//2 5 8

        // Traversing and printing the linked list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");//2 5 8 7
            temp = temp.next;
        }
    }
}