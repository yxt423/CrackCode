package leetCode;


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){  // error: fast.next ºÍ fast.next.next µÄÅÐ¶Ï
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
        
    }
}