package ch2LinkedLIst;

import java.util.Hashtable;
import java.util.HashSet;

public class deleteDups  {
	
	// use hash table //is hash table necessary?
	public static void deleteDupNodesA(Node n){
		Node previous = null;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		while(n != null){
			if(table.containsKey(n.value))
				previous.next = n.next;
			else{
				table.put(n.value, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
	//use hashset
	public static void deleteDupNodesB(Node n){
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while(n != null){
			if(set.contains(n.value)){
				previous.next = n.next;
			}
			else{
				set.add(n.value);
				previous = n;
			}
			n = n.next;
		}
	}
	
	public static void deleteDupNodesC(Node n){
		Node p1 = n;
		while(p1 != null){
			Node p2 = p1.next;
			Node previous = p1;
			while(p2 != null){
				while(p2.value == p1.value){ // the third while ensures that, if 1,1,1 exists, remove all the other 2 1s.
					previous.next = p2.next;
					p2 = p2.next;
				}
				p2 = p2.next;
				previous = previous.next;
			}
			p1 = p1.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(4);
		list.insertFirst(4);
		list.insertFirst(5);
		list.insertFirst(4);
		list.insertFirst(5);
		
		list.displayList();
		deleteDupNodesC(list.getHead());
		list.displayList();
	}

}
