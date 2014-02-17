package leetCode;

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        head = merge(head, head2);
        return head;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode post = cur.next;
        head.next = null;
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = post;
            if (post != null) {
                post = post.next;
            }
        }
        return prev;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l2 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        return dummy.next;
    }
}