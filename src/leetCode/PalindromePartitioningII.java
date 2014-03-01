package leetCode;

import java.util.Arrays;

public class PalindromePartitioningII {

    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] cuts = new int[s.length()];
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        cuts[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j > 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (j >= i - 1 || j <= i - 2 &&  palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    if (j == 0) {
                        cuts[i] = 0;
                    } else {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    }
                }
            }
        }
        
        return cuts[s.length() - 1];
    }
    
    public static void main(String[] argv) {
    	String str = "ab";
    	System.out.println(Integer.toString(minCut(str)));
    }
}