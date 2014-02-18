package leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        boolean leftToRight = true;
        while (!s.isEmpty()) {
            Stack<TreeNode> next = new Stack<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            while (!s.isEmpty()) {
                TreeNode cur = s.pop();
                level.add(cur.val);
                if (leftToRight) {
                    if (cur.left != null) next.push(cur.left);
                    if (cur.right != null) next.push(cur.right);
                } else {
                    if (cur.right != null) next.push(cur.right);
                    if (cur.left != null) next.push(cur.left);
                }
            }
            
            leftToRight = !leftToRight;
            s = next;
            result.add(level);
        }
        
        return result;
    }
}