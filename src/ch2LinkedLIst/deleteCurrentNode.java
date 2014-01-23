package ch2LinkedLIst;

// delete current node, given the access to only the current node.
//solution: copy data from next node to current node, and delete next node.
public class deleteCurrentNode {
	
	public static boolean deleteNode(Node n){
		if(n == null || n.next == null)
			return false;
		
		n.value = n.next.value;
		n.next = n.next.next;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
