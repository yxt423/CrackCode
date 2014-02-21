package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        helper(result, list, candidates, target, 0, 0);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, int[] num, int target, int sum, int pos) {
        
        if (sum == target) {
            result.add(new ArrayList<Integer>(list));
            return;
        } else if (sum > target) {
            return;
        }
        
        for (int i = pos; i < num.length; i++) {
            list.add(num[i]);
            helper(result, list, num, target, sum + num[i], i);
            list.remove(list.size() - 1);
        }
    }
}