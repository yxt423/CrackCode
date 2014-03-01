package leetCode;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || 
            triangle.get(triangle.size() - 1).size() == 0) {
            return 0;
        }
        
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] sum = new int[m][n];
        sum[0][0] = triangle.get(0).get(0);
        
        for (int i = 1; i < m; i++) {
            ArrayList<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + list.get(j);
                } else if (j == list.size() - 1) {
                    sum[i][j] = sum[i - 1][j - 1] + list.get(j);
                } else {
                    sum[i][j] = Math.min(sum[i - 1][j], sum[i - 1][j - 1]) + list.get(j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(sum[m - 1][i], min);
        }
        return min;
    }
}