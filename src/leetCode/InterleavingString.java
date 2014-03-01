package leetCode;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        } else if (s3.length() == 0) {
            return s1.length() == 0 && s2.length() == 0;
        } else if (s1.length() == 0) {
            return s3.equals(s2);
        } else if (s2.length() == 0) {
            return s3.equals(s1);
        } else if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] inter = new boolean[s1.length() + 1][s2.length() + 1];
        inter[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                inter[i][0] = true;
            } else {
                inter[i][0] = false;
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                inter[0][i] = true;
            } else {
                inter[0][i] = false;
            }
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                inter[i][j] = (inter[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
                              (inter[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return inter[s1.length()][s2.length()];
    }
}