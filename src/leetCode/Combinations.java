package leetCode;

import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n < k || n < 0) {
            return result;
        }
        helper(result, list, n, k, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, int n, int k, int pos) {
        
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < n; i++) {
            list.add(i + 1); // attention! should be i + 1, not i. 
            helper(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}