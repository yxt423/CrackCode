package leetCode;

public class BinaryTreeMaximumPathSum {
    private class ResultType {
        int singlePath, maxPath;
        ResultType(int s, int m) {
            this.singlePath = s;
            this.maxPath = m;
        }
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        //Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        
        return new ResultType(singlePath, maxPath);
    }
    
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}