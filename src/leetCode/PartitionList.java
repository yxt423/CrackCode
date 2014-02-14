package leetCode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode headl1 = new ListNode(0);
        ListNode headl2 = new ListNode(0);
        ListNode curl1 = headl1;
        ListNode curl2 = headl2;
        
        while (head != null) {
            if (head.val < x) {
                curl1.next = head;
                curl1 = curl1.next;
            } else {
                curl2.next = head;
                curl2 = curl2.next;
            }
            head = head.next;
        }
        
        if (curl1 == headl1) {
            return headl2.next;
        } else if (curl2 == headl2) {
            return headl1.next;
        } else {
            curl1.next = headl2.next;
            curl2.next = null;
            return headl1.next;
        }
    }
}