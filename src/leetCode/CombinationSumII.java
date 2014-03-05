package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        helper(result, list, num, target, 0, 0);
        
        return result;
    }
    
    private static void helper(ArrayList<ArrayList<Integer>> result, 
                        ArrayList<Integer> list, int[] num, int target, int sum, int pos) {
        
        if (sum == target) {
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            result.add(newList);
            return;
        } else if (sum > target) {
            return;
        }
        
        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            helper(result, list, num, target, sum + num[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] argv) {
    	int[] num = {10,1,2,7,6,1,5};
    	int target = 8;
    	System.out.println(combinationSum2(num, target).toString());
    }
}