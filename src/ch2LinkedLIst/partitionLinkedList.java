package ch2LinkedLIst;

public class partitionLinkedList {
	
	public static Node partition(Node head, int pivot){
		if(head == null)
			return null;
		
		Node beforeStart = null;
		Node afterStart = null;
		Node beforeEnd = null;
		Node afterEnd = null;
		Node p = head;
		
		while(p!= null){
			Node next = p.next;
			p.next = null;
			if(p.value < pivot){
				if(beforeStart == null){
					beforeStart = p;
					beforeEnd = beforeStart;
				}
				else{
					beforeEnd.next = p;
					beforeEnd = p;
				}
			}
			else{
				if(afterStart == null){
					afterStart = p;
					afterEnd = afterStart;
				}
				else{
					afterEnd.next = p;
					afterEnd = p;
				}
			}
			p = next;
		}
		
		if(beforeStart == null) // !! always thinks about exceptions!!
			return afterStart;
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}

}
