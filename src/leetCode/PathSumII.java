package leetCode;

import java.util.ArrayList;

public class PathSumII {
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, root, sum, 0);
        return result;
    }
    
    private static void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, TreeNode root, int sum,  int pathSum) {
        
        if (root == null) {
            return;
        }
        
        pathSum += root.val;
        if (root.left == null && root.right == null && pathSum == sum) {
            list.add(root.val);
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        
        list.add(root.val);
        helper(result, list, root.left, sum, pathSum);
        helper(result, list, root.right, sum, pathSum);
        list.remove(list.size() - 1);
    }

    public static void main(String[] argv) {
    	TreeNode root = new TreeNode(1);
    	System.out.println(pathSum(root, 1).toString());
    }
}