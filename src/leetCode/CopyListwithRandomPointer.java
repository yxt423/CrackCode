package leetCode;
public class CopyListwithRandomPointer {
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode copyNode = new RandomListNode(head.label);
            copyNode.next = head.next;
            head.next = copyNode;
            head = copyNode.next;
        }
    }
    
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode splitList(RandomListNode head) {
        RandomListNode head2 = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return head2;
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
}