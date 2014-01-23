package ch2LinkedLIst;

import java.util.Hashtable;

public class deleteDups {
	
	public static void deleteDupNodes(Node n){
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
