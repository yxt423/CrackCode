package leetCode;

public class RecoverBinarySearchTree {
    private TreeNode firstEle = null;
    private TreeNode secondEle = null;
    private TreeNode lastEle = new TreeNode(Integer.MIN_VALUE);
    
    // inorder traversal, visit nodes in Ascending order
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        traverse(root.left);
        // first wrong ele should be larger than original one.
        if (firstEle == null && lastEle.val > root.val) {
            firstEle = lastEle;
        }
        // second wrong ele should be smaller than original one.
        if (firstEle != null && lastEle.val > root.val) {
            secondEle = root;
        }
        lastEle = root;
        traverse(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        // get two wrong nodes
        traverse(root);
        //swap
        int temp = firstEle.val;
        firstEle.val = secondEle.val;
        secondEle.val = temp;
    }
}