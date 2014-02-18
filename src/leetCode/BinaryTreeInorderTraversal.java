package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traversal(root, result);
        return result;
    }
    
    private void traversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
    
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (s.isEmpty()) {
                return result;
            }
            cur = s.pop();
            result.add(cur.val);
            cur = cur.right;
        }
    }
}