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
	
	public Node find(int key){
		Node current = head;
		
		while(current != null){
			if(current.value == key){
				return current;
			}
			else{
				current = current.next;
			}
		}
		return null;
	}
	
	public Node delete(int key){
		Node current = head;
		Node previous = head;
		
		while(current != null){
			if(current.value == key){
				Node temp = current;
				if(current == head){
					head = head.next;
				}
				else{
					previous.next = current.next;
				}
				return temp;
			}
			else{
				previous = current;
				current = current.next;
			}
		}
		return null;
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
