package leetCode;

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copyNode = new RandomListNode(cur.label);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = copyNode.next;
        }
        
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        
        RandomListNode head2 = head.next;
        cur = head;
        while (cur != null && cur.next != null) {
            RandomListNode next = cur.next;
            if (cur.next.next != null) {
                cur.next = cur.next.next;
            } else {
                cur.next = null;
            }
            cur = next;
        }
        
        return head2;
    }
}