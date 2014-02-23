package leetCode;

public class PathSum {
    private static boolean sumEquals = false;
    
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        helper(root, sum, 0);
        return sumEquals;
    }
    
    private static void helper(TreeNode root, int sum, int pathSum) {
        if (root == null || sumEquals == true) {
            return;
        }
        
        pathSum += root.val;
        
        if (root.left == null && root.right == null && pathSum == sum) {
            sumEquals = true;
            return;
        }
        helper(root.left, sum, pathSum);
        helper(root.right, sum, pathSum);
        
    }
    
    public static void main(String[] argv) {
    	TreeNode root = new TreeNode(1);
    	System.out.println(hasPathSum(root, 0));
    }
}