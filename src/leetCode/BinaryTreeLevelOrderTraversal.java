package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // solutin 1, recursion
    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        traversal(root, result, 1);
        return result;
    }
    
    private static void traversal(TreeNode node, ArrayList<ArrayList<Integer>> result, int level){
        if (node == null){
            return;
        }
        if (result.size() < level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level - 1).add(node.val);
        level++;
        traversal(node.left, result, level);
        traversal(node.right, result, level);
    }
    
    // solution 2, queue
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}