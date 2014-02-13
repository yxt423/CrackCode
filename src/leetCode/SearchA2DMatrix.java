package leetCode;

public class SearchA2DMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        
        int start = 0;
        int end = matrix.length - 1;
        int mid;
        int row = -1;
        
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (matrix[mid][0] == target){
                row = mid;
                break;
            } else if (matrix[mid][0] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (row == -1){
            if (matrix[end][0] <= target){
                row = end;
            } else {
                row = start;
            }
        }
        
        start = 0;
        end = matrix[0].length - 1;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (matrix[row][start] == target || matrix[row][end] == target){
            return true;
        } else {
            return false;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		if (searchMatrix(M,30)){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
	}

}
