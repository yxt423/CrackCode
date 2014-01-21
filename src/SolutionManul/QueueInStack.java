package SolutionManul;

import java.util.Stack;

//Implement a queue data structure using only stacks. 
//It must support the queue and dequeue operations. Don't worry about concurrency issues.
public class QueueInStack<E> {
	
	private Stack<E> incoming = new Stack<E>();
	private Stack<E> outgoing = new Stack<E>();
	
	public void queue(E item){
		incoming.push(item);
	}
	
	public E dequeue(){
		if(outgoing.isEmpty()){
			while(!incoming.isEmpty())
				outgoing.push(incoming.pop());
		}
		return outgoing.pop();
	}

}
