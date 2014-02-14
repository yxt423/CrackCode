package leetCode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevv = dummy;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == prev.val) {
                ListNode post = cur.next;
                while (post != null && post.val == cur.val) {
                    cur = post;
                    post = post.next;
                }
                if (post == null) {
                    prevv.next = null;
                    break;
                }
                prevv.next = cur.next;
                prev = cur.next;
                cur = prev.next;
            } else {
                prevv = prevv.next;
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}