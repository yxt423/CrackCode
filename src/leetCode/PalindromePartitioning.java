package leetCode;

import java.util.ArrayList;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        helper(result, list, s, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<String>> result, 
                        ArrayList<String> list, String s, int pos) {
        
        if (pos == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for (int i = pos + 1; i <= s.length(); i++) {
            String str = s.substring(pos, i);
            if (isPalindrome(str)) {
                list.add(str);
                helper(result, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}