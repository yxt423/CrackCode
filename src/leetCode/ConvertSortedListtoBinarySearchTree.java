package leetCode;

public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            TreeNode node = new TreeNode(head.val);
            return node;
        }
        
        ListNode prevMid = findMiddle(head);
        TreeNode mid = new TreeNode(prevMid.next.val);
        if (prevMid.next.next != null) {
            mid.right = sortedListToBST(prevMid.next.next);
        }
        prevMid.next = null;
        mid.left = sortedListToBST(head);
        return mid;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}