package leetCode;

public class StrStr {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        
        int i, j;
        for (i = 0; i <= haystack.length() - needle.length(); i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return haystack.substring(i, haystack.length());
            }
        }
        
        return null;
    }
}