package leetCode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int prestart, int preend, 
                           int[] inorder, int instart, int inend) {
        if (prestart > preend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend) {
            return root;
        }
        
        int position = findPosition(inorder, preorder[prestart], instart, inend);
        root.left = build(preorder, prestart + 1, prestart + (position - instart),
                          inorder, instart, position - 1);
        root.right = build(preorder, prestart + (position - instart) + 1, preend, 
                           inorder, position + 1, inend);
        return root;
    }
    
    private int findPosition(int[] inorder, int key, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
}