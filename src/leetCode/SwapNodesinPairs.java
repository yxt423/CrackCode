package leetCode;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur1, cur2;
        ListNode post = head;
        while (post != null && post.next != null) {
            cur1 = post;
            cur2 = post.next;
            post = post.next.next;
            
            prev.next = cur2;
            cur1.next = post;
            cur2.next = cur1;
            
            prev = cur1;
        }
        
        return dummy.next;
    }
}