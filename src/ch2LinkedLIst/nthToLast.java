package ch2LinkedLIst;

public class nthToLast {
	
	// solution from cc
	public static Node nthToLastNode(Node head, int k){
		if(k<= 0 || head == null)
			return null;
		
		Node p1 = head;
		Node p2 = head;
		
		for(int i=1; i<k; i++){
			p1 = p1.next;
			if(p1 == null)
				return null;
		}
		while(p1.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	// my solution
	public static Node nthToLastNode2(Node head, int k){
		if(k<= 0 || head == null)
			return null;
		
		int size = 0;
		Node p = head;
		while(p != null){
			size++;
			p = p.next;
		}
		
		p = head;
		for(int i=1; i<(size-k); i++){
			p = p.next;
		}
		return p;
	}

}
