package leetCode;

import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private static void traverse(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return;
        }
        
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}