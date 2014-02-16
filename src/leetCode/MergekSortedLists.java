package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            cur.next = head;
            cur = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        
        return dummy.next;
    }
    
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };

}

