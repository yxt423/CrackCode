package ch2LinkedLIst;

public class DNode {
	int value;
	DNode next;
	DNode prev;
	
	public DNode(){}
	
	public DNode(int idata){
		value = idata;
	}
	
	public void displayNode(){ 
		System.out.print(value + " "); 
	}

}
