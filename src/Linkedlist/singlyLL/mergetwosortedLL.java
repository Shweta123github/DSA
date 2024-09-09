package Linkedlist.singlyLL;

import java.util.ArrayList;
import java.util.Collections;

//brute===> tc-->O((n1 + n2) log(n1 + n2))  sc--->n1+n2
public class mergetwosortedLL {
   /* ArrayList<Integer> arr = new ArrayList<>();
    Node temp1 = head1;
    Node temp2 = head2;

    while (temp1 != null) {
        arr.add(temp1.data);  // corrected 'temp11' to 'temp1'
        temp1 = temp1.next;   // corrected 'temp12' to 'temp1'
    }

    while (temp2 != null) {
        arr.add(temp2.data);
        temp2 = temp2.next;
    }

    Collections.sort(arr); // Sorting the array

    Node head = convert(arr);  // Convert the sorted array back to a linked list

    return head;

    // Method to convert array to linked list
    private Node convert(ArrayList<Integer> arr) {
        if (arr.size() == 0) return null;

        Node newHead = new Node(arr.get(0));
        Node current = newHead;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new Node(arr.get(i));
            current = current.next;
        }
        return newHead;
    }
}

*/
}

//optimal-->two pointers doni list mdhe small bagh and dummy temp tikd point kr and last la je rahilay te last la add kr sagl
//reuse nodes dont create new
//tc--->n1+n2   sc-->1
//leetcode