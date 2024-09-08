package Linkedlist.DoublyLL;


/*public class deleteoccuranceofakeyinDLL {

  public ListNode removeElements(ListNode head, int val) {
    ListNode temp = head;
    ListNode prevNode = null;

    while (temp != null) {
        if (temp.val == val) {
            if (temp == head) {
                head = temp.next;
            }
            // Update the pointers for the new node and previous node
            if (temp.next != null) {
                temp.next.prev = temp.prev;//3<-2
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;// 2 ->3
            }
            // Move to the next node
            temp = temp.next;
        } else {
            prevNode = temp;
            temp = temp.next;
        }
    }
    return head;
}


}
*/