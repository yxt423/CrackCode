package leetCode;

import java.util.ArrayList;

public class RestoreIPAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null) {
            return result;
        }
        ArrayList<Integer> dots = new ArrayList<Integer>();
        helper(result, dots, s, 0);
        return result;
    }
    
    private void helper(ArrayList<String> result, ArrayList<Integer> dots, String s, int pos) {
        if (pos == s.length() && dots.size() == 4) {
            result.add(buildIP(dots, s));
            return;
        }
        
        if (dots.size() == 3) {
            String num = s.substring(pos, s.length());
            if (s.length() - pos <= 3 && s.length() - pos > 0 && isIPNum(num)) {
                dots.add(s.length());
                helper(result, dots, s, s.length());
                dots.remove(dots.size() - 1);
            }
            return;
        }
        
        for (int i = pos + 1; i - pos <= 3 && i <= s.length(); i++) {
            String num = s.substring(pos, i);
            if (isIPNum(num)) {
                dots.add(i);
                helper(result, dots, s, i);
                dots.remove(dots.size() - 1);
            }
        }
    }
    
    private boolean isIPNum(String numStr) {
        if (numStr.charAt(0) == '0' && numStr.length() != 1) {
            return false;
        }
        int num = Integer.parseInt(numStr);
        return num >= 0 && num <= 255 ? true : false;
    }
    
    private String buildIP(ArrayList<Integer> dots, String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < dots.size() - 1; i++) {
            sb.append(s.substring(index, dots.get(i)) + ".");
            index = dots.get(i);
        }
        sb.append(s.substring(index, s.length()));
        return sb.toString();
    }
}