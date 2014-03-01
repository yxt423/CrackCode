package leetCode;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        
        int[] ways = new int[s.length()];
        ways[0] = 1;
        ways[1] = check(s.charAt(0)) * check(s.charAt(1)) + check(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length() ; i++) {
            ways[i] = check(s.charAt(i)) * ways[i - 1];
            ways[i] += check(s.charAt(i - 1), s.charAt(i)) * ways[i - 2];
        }
        
        return ways[s.length() - 1];
    }
    
    // 以每次添加的字母为单位考虑
    private int check(char a) {
        return a == '0' ? 0 : 1;
    }
    
    private int check(char a, char b) {
        return (a == '1' || a == '2' && b <= '6') ? 1 : 0;
    }
}