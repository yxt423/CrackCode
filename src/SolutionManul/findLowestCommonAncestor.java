package SolutionManul;

public class findLowestCommonAncestor {
	
	private static class Node{
		public Node leftChild;
		public Node rigthtChild;
		public int value;
	}
	
	public static Node findAncestor(Node root, int value1, int value2){
		if(root == null)
			return null;
		
		if(root.value > value1 && root.value > value2)
			return findAncestor(root.leftChild, value1, value2);
		else if(root.value < value1 && root.value < value2)
			return findAncestor(root.rigthtChild, value1, value2);
		else
			return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
