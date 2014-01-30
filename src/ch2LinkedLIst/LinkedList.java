package ch2LinkedLIst;

public class LinkedList {
	
	private Node head;
	
	public LinkedList(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void insertFirst(int idata){
		Node newNode = new Node(idata);
		newNode.next = head;
		head = newNode;
	}
	
	public Node deleteFirst(){
		if(head == null){
			return null;
		}
		else{
			Node temp = head;
			head = head.next;
			return temp;
		}
	}
	
	public void displayList(){
		Node p = head;
		while(p != null){
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
