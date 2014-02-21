package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        helper(result, list, num, 0);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, int[] num, int pos) {
        
        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < num.length; i++) {
            if ( i != pos && num[i] == num[i-1]) {
                continue;
            }
            list.add(num[i]);
            helper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}