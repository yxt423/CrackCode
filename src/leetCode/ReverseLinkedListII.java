package leetCode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
       val = x;
        next = null;
    }
}

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        int count = 1;
        
        while (count < m) {
            current = current.next;
            prev = prev.next;
            count++;
        }
        
        ListNode preListEnd = prev;
        ListNode curListStart = current;
        
        ListNode post = current.next;
        while (count < n){
            prev = current;
            current = post;
            post = post.next;
            current.next = prev;
            count++;
        }
        
        preListEnd.next = current;
        curListStart.next = post;
        return dummy.next;
    }
}