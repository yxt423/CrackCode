package leetCode;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } 
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] height = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j <= m; j++) {
                int cur = (j == m) ? -1 : height[i][j];
                while (!stack.isEmpty() && cur < height[i][stack.peek()]) {
                    int h = height[i][stack.pop()];
                    int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(j);
            }
        }
        
        return maxArea;
    }

    public static void main(String argv[]) {
    	char[][] A = new char[1][2];
    	A[0][1] = '1';
    	A[0][1] = '1';
    	System.out.print(maximalRectangle(A));
    }
}