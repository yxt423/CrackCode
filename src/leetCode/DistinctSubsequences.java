package leetCode;

import java.util.Arrays;

public class DistinctSubsequences {
    public static int numDistinct(String S, String T) {
        if (S == null || S.length() == 0 || 
            T == null || T.length() == 0 || T.length() > S.length()) {
            return 0;
        }
        
        int[][] sum = new int[T.length() + 1][S.length() + 1];
        Arrays.fill(sum[0], 1);
        
        for (int i = 1; i <= T.length() ; i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (S.charAt(j - 1) != T.charAt(i - 1)) {
                    sum[i][j] = sum[i][j - 1];
                } else {
                    sum[i][j] = sum[i][j - 1] + sum[i- 1][j - 1];
                }
            }
        }
        
        return sum[T.length()][S.length()];
    }
    
    public static void main(String[] argv) {
    	System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}