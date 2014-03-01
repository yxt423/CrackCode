package leetCode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return -1;
        } else if (word1 == null) {
            return word2.length();
        } else if (word2 == null) {
            return word1.length();
        }
        
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dis = new int[l1 + 1][l2 + 1];
        
        for (int i = 0; i <= l1; i++) {
            dis[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dis[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dis[i][j] = Math.min(dis[i - 1][j], dis[i][j - 1]) + 1;
                dis[i][j] = Math.min(dis[i][j], dis[i - 1][j - 1] + 
                            (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        
        return dis[l1][l2];
    }
}