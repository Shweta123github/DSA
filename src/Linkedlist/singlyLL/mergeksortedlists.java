package Linkedlist.singlyLL;

//brute --->tc--->n*k+mlog m+m    sc-->2m
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mergeksortedlists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Method to merge k sorted linked lists
    public Node mergeKLists(List<Node> lists) {
        List<Integer> arr = new ArrayList<>(); // Initialize an array list to collect node data

        // Loop through each list and collect all node data
        for (Node node : lists) {
            Node temp = node;
            while (temp != null) {
                arr.add(temp.data);
                temp = temp.next;
            }
        }
        //arr = [1, 4, 5, 1, 3, 4, 2, 6]

        // Sort the collected data
        Collections.sort(arr);

        // Convert sorted data back to a linked list
        return convert(arr);
    }

    // Helper method to convert an array list to a sorted linked list
    private Node convert(List<Integer> arr) {
        if (arr.isEmpty()) return null; // Handle empty list case

        Node head = new Node(arr.get(0)); // Create head node with the first element
        Node current = head;

        // Loop through the array and create linked list nodes
        for (int i = 1; i < arr.size(); i++) {
            current.next = new Node(arr.get(i));
            current = current.next;
        }

        return head; // Return the head of the new sorted linked list
    }

    public static void main(String[] args) {
        // Create individual sorted linked lists
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        // Add these lists to a list of lists
        List<Node> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        // Create an instance of mergeksortedlists
        mergeksortedlists obj = new mergeksortedlists();

        // Merge the k sorted lists
        Node mergedList = obj.mergeKLists(lists);

        // Print the merged sorted list
        printList(mergedList);
    }

    // Method to print the linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}//1 1 2 3 4 4 5 6


//optimal
//take first and second list and merge them 1 2 4 5 6
//now take first+second+third  1 1 1 2 3 4 5 6 7
//now take first+second+third+fpurth  1 1 1 2 3 4 5 6 7 8
//tc--->   sc--->1

/*class Solution {
    //i=1 asel tevha first 2 list merge
    //i=2 asel tevha pahil merge zalel and third list merge hona

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0]; // Initialize head with the first list

        for (int i = 1; i < lists.length; i++) {
            head = merge2lists(head, lists[i]);
        }

        return head;
    }

    private ListNode merge2lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
*/
//more optimized--->will use min heap concept so for this min heap we'll use priority queue
//pq mdhe sagle head add kr only and taytun min head baher ghenar like 1 and te zal vr 1 ch pudhch head honar new tr te
//prt ad in PQ
//tc-->k log k+n*k*logk   sc--->k
//23 leetcode