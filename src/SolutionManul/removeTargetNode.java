package SolutionManul;

public class removeTargetNode {
	
	private class Node{
		public Node next;
		public Node previous;
		public int value;
	}
	
	public static void removeTargetNode(Node head, int target){
		Node current = head;
		while(current != null){
			if(current.value == target){
				if(current.next != null)
					current.next.previous = current.previous;
				if(current != head)
					current.previous.next = current.next;
				return;
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

