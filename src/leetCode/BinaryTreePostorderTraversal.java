package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traversal(root, result);
        return result;
    }
    
    private void traversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) { 
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                if (cur.right != null) {
                    s.push(cur.right);
                }
                s.push(cur);
                cur = cur.left;
            }
            if (s.isEmpty()) {
                return result;
            }
            
            cur = s.pop();
            if (cur.right != null && !s.isEmpty() && cur.right == s.peek()) {
                s.pop();
                s.push(cur);
                cur = cur.right;
            } else {
                result.add(cur.val);
                cur = null;
            }
        }
    }
}