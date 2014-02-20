package leetCode;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        
        String res = "";
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        int aVal = 0, bVal = 0;
        int val = 0;
        
        while(i >= 0 || j >= 0 || carry > 0) {
            aVal = i >= 0 ? a.charAt(i) - '0' : 0;
            bVal = j >= 0 ? b.charAt(j) - '0' : 0;
            val = (aVal + bVal + carry) % 2;
            carry = (aVal + bVal + carry) / 2;
            res = Integer.toString(val) + res;
            i--;
            j--;
        }
        return res;
    }
}
