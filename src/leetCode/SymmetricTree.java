package leetCode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return symmetric(root.left, root.right);
    }
    
    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
        return false;
    }
}