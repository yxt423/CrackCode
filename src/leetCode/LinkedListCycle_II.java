package leetCode;

public class LinkedListCycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                hasCycle = true;
                break;
            }
        }
        
        if (hasCycle == true){
            ListNode p = head;
            while (p != fast){
                p = p.next;
                fast = fast.next;
            }
            return p;
        }
        return null;
    }
}