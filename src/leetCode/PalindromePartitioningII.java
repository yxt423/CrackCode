package leetCode;

public class PalindromePartitioningII {
    private static int minCuts = 0;
    
    public static int minCut(String s) {
        helper(s, 0);
        return minCuts;
    }
    
    private static void helper(String s, int pos) {
        
        for (int i = s.length(); i > pos; i--) {
            String str = s.substring(pos, i);
            if (isPalindrome(str)) {
                if (i == s.length()) {
                    return;
                } else {
                    minCuts++;
                    helper(s, i);
                }
            }
        }
    }
    
    private static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] argv) {
    	String str = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
    	System.out.println(Integer.toString(minCut(str)));
    }
}