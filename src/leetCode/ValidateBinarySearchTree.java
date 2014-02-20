package leetCode;

public class ValidateBinarySearchTree {
    private TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (! isValidBST(root.left)) {
            return false;
        }
        if (lastNode.val >= root.val) {
            return false;
        }
        lastNode = root;
        if (! isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}