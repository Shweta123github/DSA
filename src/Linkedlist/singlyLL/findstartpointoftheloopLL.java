package Linkedlist.singlyLL;

public class findstartpointoftheloopLL {
}
//for brute only two lines changes from DetectlooporcycleinLL code
//first return temp; at line 42
//second return null at line 51
//tc,sc--->n


//optimal-->tc-->n  sc-->1  tortoise and here

//public static Node firstNode(Node head) {
//    // Initialize a slow and fast
//    // pointers to the head of the list
//    Node slow = head;
//    Node fast = head;
//
//    // Phase 1: Detect the loop
//    while (fast != null && fast.next != null) {
//        slow = slow.next;
//        fast = fast.next.next;
//
//        // If slow and fast meet,
//        // a loop is detected
//        if (slow == fast) {
//           Reset the slow pointer
//           to the head of the list kont pn point ghe ek means slow head vrti asel and fast collison point vr and
//           move both
//            slow = head;
//
//            // Phase 2: Find the first node of the loop
//            while (slow != fast) {
//                // Move slow and fast one step
//                // at a time
//                slow = slow.next;
//                fast = fast.next;
//
//                // When slow and fast meet again,
//                // it's the first node of the loop
//            }
//
//            // Return the first node of the loop
//            return slow;
//        }
//    }
//
//    // If no loop is found, return null
//    return null;
//}
