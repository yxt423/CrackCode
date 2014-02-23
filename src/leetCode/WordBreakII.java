package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        
        if (s == null || dict == null) {
            return result;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String str : dict) {
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
        StringBuilder sb = new StringBuilder();
        boolean[] possible = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            possible[i] = true;
        }
        helper(result, sb, possible, s, dict, 0, min, max);
        
        return result;
    }
    
    private static void helper(ArrayList<String> result, StringBuilder sb, boolean[] possible,
                        String s, Set<String> dict, int pos, int min, int max) {
        
        if (pos == s.length()) {
            result.add(new String(sb.toString().trim()));
        }
        
        for (int i = pos + min; i <= pos + max && i <= s.length(); i++) {
            String subStr = s.substring(pos, i);
            if (dict.contains(subStr) && possible[i - 1]) {
                sb.append(subStr + " ");
                int resultSize = result.size();
                helper(result, sb, possible, s, dict, i, min, max);
                if (result.size() == resultSize) {
                    possible[i - 1] = false;
                }
                sb.delete(sb.length() - subStr.length() - 1, sb.length());
            }
        }
    }
    
    public static void main(String arvg[]) {
    	Set<String> dict = new HashSet<String>();
    	dict.add("a");
    	System.out.println(wordBreak("a",dict).toString());
    }
}