package leetCode;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode post = head;
        while (post.next != null && n > 1) {
            post = post.next;
            n--;
        }
        
        while (post.next != null) {
            post = post.next;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        
        return dummy.next;
    }
}