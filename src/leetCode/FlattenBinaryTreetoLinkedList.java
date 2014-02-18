package leetCode;

public class FlattenBinaryTreetoLinkedList {
    private TreeNode lastNode = null;
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode right = root.right; // keep track of the right node
        flatten(root.left); // the right node change after this step
        flatten(right);
    }
}