package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    // solution 1
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
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
    
    // solution 2, Divide & Conquer
    public ArrayList<Integer> preorderTraversal2(TreeNode root) { 
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
    
    // solution 3, non-recursive, using stack
    public ArrayList<Integer> preorderTraversal(TreeNode root) { 
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            result.add(cur.val);
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return result;
    }
}
