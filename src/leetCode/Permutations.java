package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        helper(result, list, num);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, int[] num) {
        
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < num.length; i++) { // every time start from 0, not position. different form subsets.
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            helper(result, list, num);
            list.remove(list.size() - 1);
        }
    }
}