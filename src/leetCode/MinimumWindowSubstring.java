package leetCode;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return "";
        }
        
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (mapT.containsKey(T.charAt(i))) {
                mapT.put(T.charAt(i), mapT.get(T.charAt(i)) + 1);
            } else {
                mapT.put(T.charAt(i), 1);
            }
        }
        
        int left = 0;
        int tCounter = 0;
        String minWindow = null;
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        
        for(int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (!mapT.containsKey(c)) {
                continue;
            } 
            
            if (mapS.containsKey(c)) {
                mapS.put(c, mapS.get(c) + 1);
            } else {
                mapS.put(c, 1);
            }
            if (mapS.get(c) <= mapT.get(c)) {
                tCounter++;
            }
            
            if (tCounter == T.length()) {
                while (left < S.length()) {
                    Character ch = S.charAt(left);
                    if (!mapT.containsKey(ch)) {
                        left++;
                        continue;
                    }
                    
                    if (mapS.get(ch) > mapT.get(ch)) {
                        mapS.put(ch, mapS.get(ch) - 1);
                        left++;
                        continue;
                    } else {
                        if (minWindow == null || S.substring(left, i + 1).length() < minWindow.length()) {
                            minWindow = S.substring(left, i + 1);
                        }
                        mapS.put(ch, mapS.get(ch) - 1);
                        left++;
                        tCounter--;
                        break;
                    }
                }
            }
        }
        
        return minWindow == null ? "" : minWindow;
    }

	public static void main(String[] args) {
		System.out.println(minWindow("a","a"));
	}
}