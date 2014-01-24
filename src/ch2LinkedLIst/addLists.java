package ch2LinkedLIst;

public class addLists {
	
	public static Node addList(Node l1, Node l2){
		Node result = null;
		Node previous = null;
		int carry = 0;
		
		while(l1 != null || l2 != null){
			int value1 = (l1 == null)? 0:l1.value;
			int value2 = (l2 == null)? 0:l2.value;
			int value = (value1 + value2 + carry)%10;
			carry = (value1 + value2 + carry)/10;
			
			Node n = new Node();
			n.value = value;
			if(result == null)
				result = n;
			else
				previous.next = n;
			previous = n;
			
			l1 = l1.next;
			l2 = l2.next;
		}
		if(carry != 0){
			Node n = new Node();
			n.value = carry;
			previous.next = n;
		}
		return result;
	}

}
