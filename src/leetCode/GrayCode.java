package leetCode;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        
        if (n <= 0) {
            return result;
        }
        
        for(int j = 0; j < n; j++) {
            int len = result.size();
            for (int i = len - 1; i >= 0; i--) {
                result.add(result.get(i) + (1 << j));
            }
        }
        return result;
    }
}