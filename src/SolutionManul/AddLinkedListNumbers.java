package SolutionManul;

public class AddLinkedListNumbers {
	
	private static class Node{
		public Node next;
		public int value;
	}
	
	public static Node Add(Node first, Node second){
		Node result = null;
		Node previous = null;
		int carry = 0;
		
		while(first != null || second != null){
			int firstValue = (first == null)? 0:first.value;
			int secondValue = (second == null)? 0:second.value;
			int value = (firstValue + secondValue + carry)%10;
			carry = (firstValue + secondValue + carry)/10;
			
			Node newNode = new Node();
			newNode.value = value;
			if(result == null){
				result = newNode;
				previous = newNode;
			}
			else{
				previous.next = newNode;
				previous = newNode;
			}
			
			first = (first.next == null)? null:first.next;
			second = (second.next == null)? null:second.next;
		}
		if(carry != 0){
			Node newNode = new Node();
			newNode.value = carry;
			previous.next = newNode;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
