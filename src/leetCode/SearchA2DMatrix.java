package leetCode;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int start = 0;
        int end = rowNum * colNum - 1;
        int mid;
        int ele;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            ele = matrix[mid / colNum][mid % colNum];
            if (ele == target) {
                return true;
            } else if (ele < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        ele = matrix[start / colNum][start % colNum];
        if (ele == target) {
            return true;
        }
        ele = matrix[end / colNum][end % colNum];
        if (ele == target) {
            return true;
        }
        return false;
    }
}