package leetCode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length) {
            return null;
        }
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] postorder, int poststart, int postend, 
                           int[] inorder, int instart, int inend) {
        if (poststart > postend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        if (poststart == postend) {
            return root;
        }
        
        int position = findPosition(inorder, postorder[postend], instart, inend);
        root.left = build(postorder, poststart, poststart + (position - instart) - 1,
                          inorder, instart, position - 1);
        root.right = build(postorder, poststart + (position - instart), postend - 1, 
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