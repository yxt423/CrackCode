package leetCode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode end = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }
        
        if (l1 == null && l2 != null) {
            end.next = l2;
        } else if (l2 == null && l1 != null) {
            end.next = l1;
        } else if (l1 == null && l2 == null) {
            ;
        }
        return dummy.next;
    }
}