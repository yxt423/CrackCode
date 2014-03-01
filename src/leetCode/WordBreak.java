package leetCode;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] can = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                can[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (can[j] && dict.contains(s.substring(j + 1, i + 1))) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[s.length() - 1];
    }
}