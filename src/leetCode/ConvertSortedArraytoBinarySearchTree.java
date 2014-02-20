package leetCode;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length - 1);
    }
    
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(num[start]);
        }
        int midIndex = start + (end - start) / 2;
        TreeNode mid = new TreeNode(num[midIndex]);
        mid.left = buildTree(num, start, midIndex - 1);
        mid.right = buildTree(num, midIndex + 1, end);
        return mid;
    }
}