package Linkedlist.singlyLL;
import java.util.HashMap;
import java.util.Map;

//min 1 node tr pahije jithun start kel and end kel vr pn tithch yenar
//hashing
//tc--->O(N * 2 * log(N))  sc--->n
public class DetectlooporcycleinLL {

    // Node class represents a node in a linked list
    static class Node {
        public int data;     // Data stored in the node
        public Node next;    // Pointer to the next node in the list

        // Constructor with both data and next node as parameters
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as a parameter, sets next to null
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

class Main {
    // Function to detect a loop in a linked list
    public static boolean detectLoop(Node head) {
        // Initialize a pointer 'temp' at the head of the linked list
        Node temp = head;

        // Create a map to keep track of encountered nodes
        Map<Node, Integer> nodeMap = new HashMap<>();

        // Step 2: Traverse the linked list
        while (temp != null) {
            // If the node is already in the map, there is a loop
            if (nodeMap.containsKey(temp)) {
                return true;
            }
            // Store the current node in the map
            nodeMap.put(temp, 1);
            // Move to the next node
            temp = temp.next;
        }

        // Step 3: If the list is successfully traversed without a loop, return false
        return false;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a loop for testing
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        // Check if there is a loop in the linked list
        if (detectLoop(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }//true
}

//optimal --->using tortosizeand hare  when slow and fast stand in same node means there is a loop
//tc-->n sc-->1


