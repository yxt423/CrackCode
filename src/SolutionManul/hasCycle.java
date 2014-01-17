package SolutionManul;

public class hasCycle {
	
	private class Node{
		public Node next;
		public int value;
	}
	
	public static boolean solution(Node head){
		if(head == null)
			return false;
		Node p1 = head;
		Node p2 = head;
		
		while(true){
			p1 = p1.next;
			if(p2.next != null)
				p2= p2.next.next;
			else
				return false;
			if(p1 == null || p2 == null)
				return false;
			if(p1 == p2)
				return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
