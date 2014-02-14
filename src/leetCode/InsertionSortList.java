package leetCode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            ListNode insertp = dummy;
            while (insertp.next != null && insertp.next.val < cur.val) {
                insertp = insertp.next;
            }
            cur.next = insertp.next;
            insertp.next = cur;
            cur = next;
        }
        
        return dummy.next;
    }
}