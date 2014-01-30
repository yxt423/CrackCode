package ch2LinkedLIst;

public class LinkStack {
	
	private LinkedList theList;
	
	public LinkStack(){
		theList = new LinkedList();
	}
	
	public void push(int i){
		theList.insertFirst(i);
	}
	
	public Node pop(){
		return theList.deleteFirst();
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
