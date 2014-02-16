package leetCode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        cur.next = head;
        
        for (int i = 0; i < (count - n % count); i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}