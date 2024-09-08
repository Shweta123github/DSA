package Linkedlist.DoublyLL;

//tc--->n sc--->1
public class RemoveduplicatesfromsortedDDL {
    //two pointers
public Node removeDuplicates(Node head) {
    if (head == null) return null;

    Node temp = head;

    while (temp != null && temp.next != null) {
        Node nextNode = temp.next;

        // Remove nodes with the same value skip duplicate and goto nextnode
        while (nextNode != null && nextNode.val == temp.val) {
            nextNode = nextNode.next;
        }

        // Connect the current node to the next unique node 1 skip zal so newnode updated
        temp.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = temp;//2 back to 1
        }

        // Move to the next node
        temp = temp.next;
    }

    return head;
}

// Node class definition for doubly linked list
public static class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
}