package SolutionManul;

public class isValidBST {
	
	private static class Node{
		public Node leftChild;
		public Node rigthtChild;
		public int value;
	}
	
	public static boolean func(Node root){
		return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static boolean isBST(Node current, int min, int max){
		if(current.leftChild != null){
			if(current.leftChild.value < min || !isBST(current.leftChild, min, current.value))
				return false;
		}
		if(current.rigthtChild != null){
			if(current.rigthtChild.value > max || !isBST(current.rigthtChild, current.value, max))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
