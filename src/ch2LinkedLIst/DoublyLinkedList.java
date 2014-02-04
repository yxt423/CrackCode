package ch2LinkedLIst;

public class DoublyLinkedList {
	
	private DNode first;
	private DNode last;
	
	public DoublyLinkedList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(int idata){
		DNode newNode = new DNode(idata);
		if(isEmpty()){
			last = newNode;
		}
		else{
			newNode.next = first;
			first.prev = newNode;
		}
		first = newNode;
	}
	
	public void insertLast(int value){
		DNode newNode = new DNode(value);
		if(isEmpty()){
			first = newNode;
		}
		else{
			last.next = newNode;
			newNode.prev = last;
		}
		last = newNode;
	}
	
	public DNode deleteFirst(){
		DNode temp = first;
		if(first.next != null){
			first.next.prev = null;
		}
		else{
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public DNode deleteLast(){
		DNode temp = last;
		if(last.prev != null){
			last.prev.next = null;
		}
		else{
			first = null;
		}
		last = last.prev;
		return temp;
	}
	
	public boolean insertAfter(int key, int value){
		DNode newNode = new DNode(value);
		DNode current = first;
		while(current != null){
			if(current.value == key){ /* insert */
				if(current != last){
					newNode.next = current.next;
					newNode.prev = current;
					current.next.prev = newNode;
					current.next = newNode;
				}
				else{
					last.next = newNode;
					newNode.prev = last;
					last = newNode;
				}
				return true;
			}
			else{ /* current point to next*/
				current = current.next;
			}
		}
		return false; /* didn't find it*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
