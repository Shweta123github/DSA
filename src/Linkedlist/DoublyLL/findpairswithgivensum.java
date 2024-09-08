package Linkedlist.DoublyLL;
import java.util.ArrayList;
import java.util.List;

//take 2 pointers
//brute--->n^2  sc-->1
public class findpairswithgivensum {
  /*  public List<int[]> findPairsWithGivenSum(ListNode head, int sum) {
            List<int[]> ds = new ArrayList<>();
            ListNode temp1 = head;

            while (temp1 != null) {
                ListNode temp2 = temp1.next;

                while (temp2 != null && temp1.val+temp2.val<=sum) {
                    if (temp1.val + temp2.val == sum) {
                        ds.add(new int[]{temp1.val, temp2.val});
                    }
                    temp2 = temp2.next;
                }

                temp1 = temp1.next;
            }

            return ds;
        }
    }

    // Define the ListNode class as it is required for this solution
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
*/
//optimal --->its sorted doubly LL


    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to find the tail of the doubly linked list
    public static class LinkedListPairs {

        public Node findTail(Node head) {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            return tail;
        }

        // Method to find pairs in the doubly linked list that sum up to k
        public List<int[]> findPairs(Node head, int k) {
            List<int[]> ans = new ArrayList<>();
            if (head == null) return ans;

            Node left = head;
            Node right = findTail(head);

            while (left != null && right != null && left.data < right.data) {
                int sum = left.data + right.data;
                if (sum == k) {
                    ans.add(new int[]{left.data, right.data});
                    left = left.next;
                    right = right.prev;
                } else if (sum < k) {
                    left = left.next;
                } else {
                    right = right.prev;
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            // Example usage
            Node head = new Node(1);
            head.next = new Node(2);
            head.next.prev = head;
            head.next.next = new Node(3);
            head.next.next.prev = head.next;
            head.next.next.next = new Node(4);
            head.next.next.next.prev = head.next.next;
            head.next.next.next.next = new Node(5);
            head.next.next.next.next.prev = head.next.next.next;

            LinkedListPairs listPairs = new LinkedListPairs();
            List<int[]> pairs = listPairs.findPairs(head, 6);

            for (int[] pair : pairs) {
                System.out.println(pair[0] + " " + pair[1]);
            }
        } //1 5  2 4
    }
}

